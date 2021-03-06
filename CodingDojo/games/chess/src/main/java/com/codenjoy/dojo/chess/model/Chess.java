package com.codenjoy.dojo.chess.model;

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



import com.codenjoy.dojo.chess.model.figures.Figure;
import com.codenjoy.dojo.chess.model.figures.Level;
import com.codenjoy.dojo.chess.services.GameSettings;
import com.codenjoy.dojo.services.printer.BoardReader;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.Tickable;

import java.util.LinkedList;
import java.util.List;

public class Chess implements Field {

    private List<Figure> white;
    private List<Figure> black;

    private List<Player> players;

    private final int size;
    private Dice dice;

    private GameSettings settings;

    public Chess(Level level, Dice dice, GameSettings settings) {
        this.dice = dice;
        size = level.getSize();
        this.settings = settings;
        players = new LinkedList<>();
        white = level.getFigures(true);
        black = level.getFigures(false);
    }

    @Override
    public void tick() {
        for (Player player : players) {
            for (Figure figure : player.getFigures()) {
                figure.tick();
            }
        }
    }

    public int size() {
        return size;
    }

    @Override
    public void newGame(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
        player.initFigures(this);
    }

    @Override
    public void remove(Player player) {
        players.remove(player);
    }

    public List<Figure> getWhite() {
        return white;
    }

    @Override
    public BoardReader reader() {
        return new BoardReader() {
            private int size = Chess.this.size;

            @Override
            public int size() {
                return size;
            }

            @Override
            public Iterable<? extends Point> elements() {
                return new LinkedList<Point>(){{
                    addAll(white);
                    addAll(black);
                }};
            }
        };
    }

    @Override
    public List<Figure> getFigures(boolean isWhite) {
        if (isWhite) {
            return white;
        } else {
            return black;
        }
    }

    @Override
    public GameSettings settings() {
        return settings;
    }
}
