package com.codenjoy.dojo.bomberman.services;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 - 2020 Codenjoy
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

import com.codenjoy.dojo.bomberman.model.Elements;
import com.codenjoy.dojo.bomberman.model.perks.PerkSettings;
import com.codenjoy.dojo.bomberman.model.perks.PerksSettingsWrapper;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.settings.Settings;
import com.codenjoy.dojo.utils.JsonUtils;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GameSettingsTest {

    @Mock
    private Dice dice;

    @Mock
    Settings settings;

    @Test
    @Ignore("TODO: mock GameSettings properly")
    public void shouldBombermanContainPerksSettings_whenCreated() {
        GameSettings settings = new GameSettings();
        PerksSettingsWrapper perksSettings = settings.perksSettings();
        PerkSettings perkSettings = perksSettings.get(Elements.BOMB_IMMUNE);

        assertPerkSettings(Elements.BOMB_BLAST_RADIUS_INCREASE, perkSettings, 2, 10);
        assertPerkSettings(Elements.BOMB_COUNT_INCREASE, perkSettings, 3, 10);
        assertPerkSettings(Elements.BOMB_IMMUNE, perkSettings, 0, 10);
        assertPerkSettings(Elements.BOMB_REMOTE_CONTROL, perkSettings, 0, 3);
    }

    private boolean assertPerkSettings(Elements perk, PerkSettings perkSettings, int value, int timeout) {
        String message = "";
        String defaultValueErrorPattern = "%s expected default value = %d, but found it = %d \n";
        String defaultTimeoutErrorPattern = "%s expected default timeout = %d, but found it = %d \n";

        if(perkSettings.value() != value) {
            message += String.format(defaultValueErrorPattern, perk.name(), value, perkSettings.value());
        }

        if(perkSettings.timeout() != timeout) {
            message += String.format(defaultTimeoutErrorPattern, perk.name(), timeout, perkSettings.timeout());
        }

        if(message.isEmpty()) {
            return true;
        } else {
            throw  new AssertionError(message);
        }
    }

    @Test
    public void testUpdate() {
        // given
        GameSettings settings = new GameSettings();

        assertEquals("{\n" +
                "  'BIG_BADABOOM':false,\n" +
                "  'BOARD_SIZE':23,\n" +
                "  'BOMBS_COUNT':1,\n" +
                "  'BOMB_POWER':3,\n" +
                "  'CATCH_PERK_SCORE':5,\n" +
                "  'DEFAULT_PERKS':'r+ic',\n" +
                "  'DESTROY_WALL_COUNT':52,\n" +
                "  'DIE_PENALTY':30,\n" +
                "  'KILL_MEAT_CHOPPER_SCORE':10,\n" +
                "  'KILL_OTHER_HERO_SCORE':20,\n" +
                "  'KILL_WALL_SCORE':1,\n" +
                "  'MEAT_CHOPPERS_COUNT':5,\n" +
                "  'MIN_TICKS_FOR_WIN':1,\n" +
                "  'MULTIPLE':false,\n" +
                "  'PERK_BOMB_BLAST_RADIUS_INC':2,\n" +
                "  'PERK_BOMB_COUNT_INC':4,\n" +
                "  'PERK_DROP_RATIO':20,\n" +
                "  'PERK_PICK_TIMEOUT':30,\n" +
                "  'PLAYERS_PER_ROOM':5,\n" +
                "  'REMOTE_CONTROL_COUNT':3,\n" +
                "  'ROUNDS_ENABLED':true,\n" +
                "  'ROUNDS_PER_MATCH':1,\n" +
                "  'TIMEOUT_BOMB_BLAST_RADIUS_INC':30,\n" +
                "  'TIMEOUT_BOMB_COUNT_INC':30,\n" +
                "  'TIMEOUT_BOMB_IMMUNE':30,\n" +
                "  'TIME_BEFORE_START':5,\n" +
                "  'TIME_FOR_WINNER':1,\n" +
                "  'TIME_PER_ROUND':200,\n" +
                "  'WIN_ROUND_SCORE':30\n" +
                "}", JsonUtils.prettyPrint(settings.asJson()));

        // when
        settings.update(new JSONObject("{\n" +
                "  'DIE_PENALTY':12,\n" +
                "  'MULTIPLE':true,\n" +
                "  'PERK_BOMB_BLAST_RADIUS_INC':4,\n" +
                "  'PERK_DROP_RATIO':23,\n" +
                "  'ROUNDS_ENABLED':false,\n" +
                "  'TIME_BEFORE_START':10,\n" +
                "  'TIMEOUT_BOMB_COUNT_INC':12,\n" +
                "}"));

        // then
        assertEquals("{\n" +
                "  'BIG_BADABOOM':false,\n" +
                "  'BOARD_SIZE':23,\n" +
                "  'BOMBS_COUNT':1,\n" +
                "  'BOMB_POWER':3,\n" +
                "  'CATCH_PERK_SCORE':5,\n" +
                "  'DEFAULT_PERKS':'r+ic',\n" +
                "  'DESTROY_WALL_COUNT':52,\n" +
                "  'DIE_PENALTY':12,\n" +
                "  'KILL_MEAT_CHOPPER_SCORE':10,\n" +
                "  'KILL_OTHER_HERO_SCORE':20,\n" +
                "  'KILL_WALL_SCORE':1,\n" +
                "  'MEAT_CHOPPERS_COUNT':5,\n" +
                "  'MIN_TICKS_FOR_WIN':1,\n" +
                "  'MULTIPLE':true,\n" +
                "  'PERK_BOMB_BLAST_RADIUS_INC':4,\n" +
                "  'PERK_BOMB_COUNT_INC':4,\n" +
                "  'PERK_DROP_RATIO':23,\n" +
                "  'PERK_PICK_TIMEOUT':30,\n" +
                "  'PLAYERS_PER_ROOM':5,\n" +
                "  'REMOTE_CONTROL_COUNT':3,\n" +
                "  'ROUNDS_ENABLED':false,\n" +
                "  'ROUNDS_PER_MATCH':1,\n" +
                "  'TIMEOUT_BOMB_BLAST_RADIUS_INC':30,\n" +
                "  'TIMEOUT_BOMB_COUNT_INC':12,\n" +
                "  'TIMEOUT_BOMB_IMMUNE':30,\n" +
                "  'TIME_BEFORE_START':10,\n" +
                "  'TIME_FOR_WINNER':1,\n" +
                "  'TIME_PER_ROUND':200,\n" +
                "  'WIN_ROUND_SCORE':30\n" +
                "}", JsonUtils.prettyPrint(settings.asJson()));

        // when
        settings.update(new JSONObject("{}"));

        // then
        assertEquals("{\n" +
                "  'BIG_BADABOOM':false,\n" +
                "  'BOARD_SIZE':23,\n" +
                "  'BOMBS_COUNT':1,\n" +
                "  'BOMB_POWER':3,\n" +
                "  'CATCH_PERK_SCORE':5,\n" +
                "  'DEFAULT_PERKS':'r+ic',\n" +
                "  'DESTROY_WALL_COUNT':52,\n" +
                "  'DIE_PENALTY':12,\n" +
                "  'KILL_MEAT_CHOPPER_SCORE':10,\n" +
                "  'KILL_OTHER_HERO_SCORE':20,\n" +
                "  'KILL_WALL_SCORE':1,\n" +
                "  'MEAT_CHOPPERS_COUNT':5,\n" +
                "  'MIN_TICKS_FOR_WIN':1,\n" +
                "  'MULTIPLE':true,\n" +
                "  'PERK_BOMB_BLAST_RADIUS_INC':4,\n" +
                "  'PERK_BOMB_COUNT_INC':4,\n" +
                "  'PERK_DROP_RATIO':23,\n" +
                "  'PERK_PICK_TIMEOUT':30,\n" +
                "  'PLAYERS_PER_ROOM':5,\n" +
                "  'REMOTE_CONTROL_COUNT':3,\n" +
                "  'ROUNDS_ENABLED':false,\n" +
                "  'ROUNDS_PER_MATCH':1,\n" +
                "  'TIMEOUT_BOMB_BLAST_RADIUS_INC':30,\n" +
                "  'TIMEOUT_BOMB_COUNT_INC':12,\n" +
                "  'TIMEOUT_BOMB_IMMUNE':30,\n" +
                "  'TIME_BEFORE_START':10,\n" +
                "  'TIME_FOR_WINNER':1,\n" +
                "  'TIME_PER_ROUND':200,\n" +
                "  'WIN_ROUND_SCORE':30\n" +
                "}", JsonUtils.prettyPrint(settings.asJson()));

    }
}
