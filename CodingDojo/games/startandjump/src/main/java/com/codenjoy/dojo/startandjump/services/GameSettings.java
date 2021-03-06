/*-
 * #%L
 * expansion - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 - 2020 Codenjoy
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

package com.codenjoy.dojo.startandjump.services;

import com.codenjoy.dojo.services.settings.SettingsImpl;
import com.codenjoy.dojo.services.settings.SettingsReader;
import com.codenjoy.dojo.startandjump.model.Level;
import com.codenjoy.dojo.startandjump.model.LevelImpl;

import static com.codenjoy.dojo.startandjump.services.GameSettings.Keys.*;

public class GameSettings extends SettingsImpl implements SettingsReader<GameSettings> {

    public enum Keys implements Key {

        WIN_SCORE("Win score"),
        LOOSE_PENALTY("Loose penalty"),
        LEVEL_MAP("Level map");

        private String key;

        Keys(String key) {
            this.key = key;
        }

        @Override
        public String key() {
            return key;
        }
    }

    public GameSettings() {
        integer(WIN_SCORE, 30);
        integer(LOOSE_PENALTY, 100);

        multiline(LEVEL_MAP,
                "####################" +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                " =                  " +
                "                    " +
                "☺            ==  ===" +
                " =        =         " +
                " =  ==== = ==       " +
                "####################");
    }

    public Level level() {
        return new LevelImpl(string(LEVEL_MAP));
    }

}
