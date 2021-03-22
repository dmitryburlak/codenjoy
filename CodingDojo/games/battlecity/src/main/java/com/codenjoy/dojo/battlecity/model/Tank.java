package com.codenjoy.dojo.battlecity.model;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.battlecity.model.items.Bullet;
import com.codenjoy.dojo.battlecity.model.items.Prize;
import com.codenjoy.dojo.battlecity.model.items.Prizes;
import com.codenjoy.dojo.battlecity.model.items.Tree;
import com.codenjoy.dojo.battlecity.services.GameSettings;
import com.codenjoy.dojo.services.*;
import com.codenjoy.dojo.services.multiplayer.PlayerHero;
import com.codenjoy.dojo.services.round.Timer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.codenjoy.dojo.battlecity.model.Elements.PRIZE_BREAKING_WALLS;
import static com.codenjoy.dojo.battlecity.model.Elements.PRIZE_WALKING_ON_WATER;
import static com.codenjoy.dojo.battlecity.services.GameSettings.Keys.PENALTY_WALKING_ON_WATER;
import static com.codenjoy.dojo.battlecity.services.GameSettings.Keys.TANK_TICKS_PER_SHOOT;
import static com.codenjoy.dojo.services.StateUtils.filterOne;

public class Tank extends PlayerHero<Field> implements State<Elements, Player> {

    public static final int MAX = 100;

    protected Dice dice;

    private boolean alive;
    protected Direction direction;
    protected boolean moving;
    private boolean fire;

    private Gun gun;
    private Sliding sliding;

    private List<Bullet> bullets;
    private Prizes prizes;

    private Timer onWater;

    public Tank(Point pt, Direction direction, Dice dice) {
        super(pt);
        this.direction = direction;
        this.dice = dice;
        bullets = new LinkedList<>();
        prizes = new Prizes();
    }

    @Override
    public GameSettings settings() {
        return (GameSettings) field.settings();
    }

    @Override
    public void up() {
        if (!alive) return;

        direction = Direction.UP;
        moving = true;
    }

    @Override
    public void down() {
        if (!alive) return;

        direction = Direction.DOWN;
        moving = true;
    }

    @Override
    public void right() {
        if (!alive) return;

        direction = Direction.RIGHT;
        moving = true;
    }

    @Override
    public void left() {
        if (!alive) return;

        direction = Direction.LEFT;
        moving = true;
    }

    public Direction getDirection() {
        return direction;
    }

    public void move() {
        moving = moving || field.isIce(this);
        if (!moving) return;

        if (sliding.active(this)) {
            direction = sliding.affect(direction);
        }

        moving(direction.change(this));
    }

    public void moving(Point pt) {
        if (field.isBarrierFor(this, pt)) {
            sliding.stop();
        } else {
            move(pt);
        }
        moving = false;
    }

    @Override
    public void act(int... p) {
        if (!alive) return;

        fire = true;
    }

    public Collection<Bullet> getBullets() {
        return new LinkedList<>(bullets);
    }

    public void init(Field field) {
        super.init(field);

        gun = new Gun(settings());
        sliding = new Sliding(field, direction, settings());

        reset();

        int c = 0;
        Point pt = this;
        while (field.isBarrier(pt) && c++ < MAX) {
            pt = PointImpl.random(dice, field.size());
        }
        if (c >= MAX) {
            alive = false;
            return;
        }
        move(pt);
        alive = true;
    }

    protected int ticksPerShoot() {
        return settings().integer(TANK_TICKS_PER_SHOOT);
    }

    public void kill(Bullet bullet) {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void removeBullets() {
        bullets.clear();
    }

    @Override
    public void tick() {
        gunType();

        gun.tick();
        prizes.tick();

        checkOnWater();
    }

    public void checkOnWater() {
        if (field.isRiver(this) && !prizes.contains(PRIZE_WALKING_ON_WATER)) {
            if (onWater == null || onWater.done()) {
                onWater = new Timer(settings().integerValue(PENALTY_WALKING_ON_WATER));
                onWater.start();
            }
            onWater.tick(() -> {});
        } else {
            onWater = null;
        }
    }

    @Override
    public Elements state(Player player, Object... alsoAtPoint) {
        Elements tree = player.getHero().treeState(alsoAtPoint);
        if (tree != null) {
            return tree;
        }

        if (isAlive()) {
            if (player.getHero() == this) {
                switch (direction) {
                    case LEFT:  return Elements.TANK_LEFT;
                    case RIGHT: return Elements.TANK_RIGHT;
                    case UP:    return Elements.TANK_UP;
                    case DOWN:  return Elements.TANK_DOWN;
                    default:    throw new RuntimeException("Неправильное состояние танка!");
                }
            } else {
                switch (direction) {
                    case LEFT:  return Elements.OTHER_TANK_LEFT;
                    case RIGHT: return Elements.OTHER_TANK_RIGHT;
                    case UP:    return Elements.OTHER_TANK_UP;
                    case DOWN:  return Elements.OTHER_TANK_DOWN;
                    default:    throw new RuntimeException("Неправильное состояние танка!");
                }
            }
        } else {
            return Elements.BANG;
        }
    }

    public Elements treeState(Object[] alsoAtPoint) {
        Tree tree = filterOne(alsoAtPoint, Tree.class);
        if (tree == null) {
            return null;
        }

        if (prizes.contains(Elements.PRIZE_VISIBILITY)) {
            return null;
        }

        return Elements.TREE;
    }

    public void reset() {
        moving = false;
        fire = false;
        alive = true;
        gun.reset();
        bullets.clear();
        prizes.clear();
    }

    public void tryFire() {
        if (!fire) return;
        fire = false;

        if (!gun.tryToFire()) return;

        Bullet bullet = new Bullet(field, direction, copy(), this,
                b -> Tank.this.bullets.remove(b));

        if (!bullets.contains(bullet)) {
            bullets.add(bullet);
        }
    }

    protected boolean withPrize() {
        return false;
    }

    public Prizes prizes() {
        return prizes;
    }

    public void take(Prize prize) {
        prizes.add(prize);
    }

    private void gunType() {
        if (prizes.contains(PRIZE_BREAKING_WALLS)) {
            gun.machineGun();
        }
    }

    public boolean canWalkOnWater() {
        return prizes.contains(PRIZE_WALKING_ON_WATER)
                || (onWater != null && onWater.done());
    }
}
