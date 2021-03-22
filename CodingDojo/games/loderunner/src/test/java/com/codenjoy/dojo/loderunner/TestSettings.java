package com.codenjoy.dojo.loderunner;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 - 2019 Codenjoy
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

import com.codenjoy.dojo.loderunner.services.GameSettings;

import static com.codenjoy.dojo.loderunner.services.GameSettings.Keys.*;

public class TestSettings extends GameSettings {

    public TestSettings() {
        integer(KILL_HERO_PENALTY, 0);
        integer(KILL_ENEMY_SCORE, 10);

        integer(SUICIDE_PENALTY, 0);
        integer(SHADOW_TICKS, 15);
        integer(SHADOW_PILLS_COUNT, 0);
        integer(PORTAL_TICKS, 10);
        integer(PORTALS_COUNT, 0);
        string(MAP_PATH, "");

        integer(GOLD_COUNT_YELLOW, -1);
        integer(GOLD_COUNT_GREEN, 0);
        integer(GOLD_COUNT_RED, 0);
        integer(GOLD_SCORE_YELLOW, 1);
        integer(GOLD_SCORE_GREEN, 5);
        integer(GOLD_SCORE_RED, 10);

        integer(ENEMIES_COUNT, 0);
    }
}