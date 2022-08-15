/*
 * Copyright (c) 2021, 117 <https://twitter.com/117scape>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package rs117.hd.data.materials;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import net.runelite.api.Client;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import rs117.hd.HdPluginConfig;
import rs117.hd.data.WaterType;
import rs117.hd.data.environments.Area;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public enum Underlay {

    // Default
    // Lumbridge
    LUMBRIDGE_CASTLE_TILE(56, Area.LUMBRIDGE_CASTLE_BASEMENT, GroundMaterial.MARBLE_2_SEMIGLOSS, p -> p.blended(false)),

    // Edgeville
    EDGEVILLE_PATH_OVERLAY_48(48, Area.EDGEVILLE_PATH_OVERLAY, GroundMaterial.VARROCK_PATHS_LIGHT, p -> p
        .blendedAsType(true)
        .hue(0)
        .shiftLightness(8)
        .saturation(0)
        .ids(50, 64)),

    // Varrock
    VARROCK_JULIETS_HOUSE_UPSTAIRS(8, Area.VARROCK_JULIETS_HOUSE, GroundMaterial.NONE, p -> p.blended(false)),
    // A Soul's Bane
    TOLNA_DUNGEON_ANGER_FLOOR(58, Area.TOLNA_DUNGEON_ANGER, GroundMaterial.DIRT, p -> p.ids(58)),

    // Burthorpe
    WARRIORS_GUILD_FLOOR_1(55, Area.WARRIORS_GUILD, GroundMaterial.VARROCK_PATHS, p -> p.ids(56)),

    // Catherby
    CATHERBY_BEACH_SAND(62, Area.CATHERBY, GroundMaterial.SAND),

    // Al Kharid
    MAGE_TRAINING_ARENA_FLOOR_PATTERN(56, Area.MAGE_TRAINING_ARENA, GroundMaterial.TILES_2x2_2_GLOSS, p -> p.blended(false)),

    KHARID_SAND_1(61, Area.KHARID_DESERT_REGION, GroundMaterial.SAND, p -> p
        .saturation(3)
        .hue(6)
        .ids(62, 67, 68, -127, 126, 49, 58, 63, 64, 50)),

    // Burthorpe games room
    GAMES_ROOM_INNER_FLOOR(64, Area.GAMES_ROOM_INNER, GroundMaterial.CARPET, p -> p.blended(false)),
    GAMES_ROOM_FLOOR(64, Area.GAMES_ROOM, GroundMaterial.WOOD_PLANKS_1, p -> p.blended(false)),

    // Crandor
    CRANDOR_SAND(-110, Area.CRANDOR, GroundMaterial.SAND, p -> p.saturation(3).hue(6)),

    // God Wars Dungeon (GWD)
    GOD_WARS_DUNGEON_SNOW_1(58, Area.GOD_WARS_DUNGEON, GroundMaterial.SNOW_1, p -> p.ids(59)),

    // TzHaar
    INFERNO_1(-118, Area.THE_INFERNO, GroundMaterial.VARIED_DIRT, p -> p.ids(61, -115, -111, -110, 1, 61, 62, 72, 118, 122)),

    TZHAAR(72, Area.TZHAAR, GroundMaterial.VARIED_DIRT_SHINY, p -> p.shiftLightness(2)),

    // Morytania
    VER_SINHAZA_WATER_FIX(54, p -> p.area(Area.VER_SINHAZA_WATER_FIX).waterType(WaterType.WATER).blended(false)),

    // Castle Wars
    CENTER_SARADOMIN_SIDE_DIRT_1(98, Area.CASTLE_WARS_ARENA_SARADOMIN_SIDE, GroundMaterial.DIRT, p -> p
        .hue(7)
        .saturation(4)),
    CENTER_SARADOMIN_SIDE_DIRT_2(56, Area.CASTLE_WARS_ARENA_SARADOMIN_SIDE, GroundMaterial.DIRT, p -> p
        .hue(7)
        .saturation(4)
        .shiftLightness(3)),

    // Zanaris
    COSMIC_ENTITYS_PLANE_ABYSS(72, Area.COSMIC_ENTITYS_PLANE, GroundMaterial.NONE, p -> p
        .lightness(0)
        .blended(false)
        .ids(2)),

    // Death's office
    DEATHS_OFFICE_TILE(-110, Area.DEATHS_OFFICE, GroundMaterial.TILES_2x2_1_SEMIGLOSS),

    // Chambers of Xeric
    COX_SNOW_1(16, Area.COX_SNOW, GroundMaterial.SNOW_1),
    COX_SNOW_2(59, Area.COX_SNOW, GroundMaterial.SNOW_2),

    // Mind Altar
    MIND_ALTAR_TILE(55, Area.MIND_ALTAR, GroundMaterial.MARBLE_1_SEMIGLOSS, p -> p.blended(false)),

    // Cutscenes
    CANOE_CUTSCENE_GRASS_1(48, Area.CANOE_CUTSCENE, GroundMaterial.GRASS_SCROLLING, p -> p.ids(50, 63)),

    WINTER_GRASS(-999, GroundMaterial.SNOW_1, p -> p.hue(0).saturation(0).shiftLightness(40).blended(true)),
    WINTER_DIRT(-999, GroundMaterial.DIRT, p -> p.hue(0).saturation(0).shiftLightness(40).blended(true)),

    // default underlays

    OVERWORLD_UNDERLAY_GRASS(10, Area.OVERWORLD, GroundMaterial.OVERWORLD_GRASS_1, p -> p
        .ids(25, 33, 34, 40, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 62, 63, 67, 70, 75, 93, 96, 97, 103, 114, 115, 126)
        .replaceWithIf(WINTER_GRASS, HdPluginConfig::winterTheme)),

    OVERWORLD_UNDERLAY_DIRT(-111, Area.OVERWORLD, GroundMaterial.OVERWORLD_DIRT, p -> p
        .ids(-110, 64, 65, 66, 80, 92, 94)
        .replaceWithIf(WINTER_DIRT, HdPluginConfig::winterTheme)),

    OVERWORLD_UNDERLAY_SAND(-127, GroundMaterial.SAND, p -> p.ids(-118, 61, 68)),

    OVERWORLD_DIRT(-111, GroundMaterial.DIRT, p -> p.ids(-110, 64, 66, 80, 92, 94)),

    UNDERLAY_10(10, GroundMaterial.GRASS_1, p -> p.ids(25, 33, 34, 40, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 62, 63, 67, 70, 75, 93, 96, 97, 103, 103, 114, 115, 126)),

    UNDERLAY_58(58, GroundMaterial.SNOW_1),

    UNDERLAY_72(72, GroundMaterial.VARIED_DIRT, p -> p.ids(90)),

    NONE(-1, GroundMaterial.DIRT);

    public final Integer[] ids;
    public final Area area;
    public final GroundMaterial groundMaterial;
    public final WaterType waterType;
    public final boolean blended;
    public final boolean blendedAsUnderlay;
    public final int hue;
    public final int shiftHue;
    public final int saturation;
    public final int shiftSaturation;
    public final int lightness;
    public final int shiftLightness;
    public final Underlay replacementUnderlay;
    public final Function<HdPluginConfig, Boolean> replacementCondition;

    Underlay(int id, GroundMaterial material) {
        this(p -> p.ids(id).groundMaterial(material));
    }

    Underlay(int id, GroundMaterial material, Consumer<TileOverrideBuilder<Underlay>> consumer) {
        this(p -> p.ids(id).groundMaterial(material).apply(consumer));
    }

    Underlay(int id, Consumer<TileOverrideBuilder<Underlay>> consumer) {
        this(p -> p.ids(id).apply(consumer));
    }

    Underlay(int id, Area area, GroundMaterial material, Consumer<TileOverrideBuilder<Underlay>> consumer) {
        this(p -> p.ids(id).groundMaterial(material).area(area).apply(consumer));
    }

    Underlay(int id, Area area, GroundMaterial material) {
        this(p -> p.ids(id).groundMaterial(material).area(area));
    }

    Underlay(Consumer<TileOverrideBuilder<Underlay>> consumer) {
        TileOverrideBuilder<Underlay> builder = new TileOverrideBuilder<>();
        consumer.accept(builder);
        this.ids = builder.ids;
        this.replacementUnderlay = builder.replacement;
        this.replacementCondition = builder.replacementCondition;
        this.waterType = builder.waterType;
        this.groundMaterial = builder.groundMaterial;
        this.area = builder.area;
        this.blended = builder.blended;
        this.blendedAsUnderlay = builder.blendedAsType;
        this.hue = builder.hue;
        this.shiftHue = builder.shiftHue;
        this.saturation = builder.saturation;
        this.shiftSaturation = builder.shiftSaturation;
        this.lightness = builder.lightness;
        this.shiftLightness = builder.shiftLightness;
    }

    private static final ListMultimap<Integer, Underlay> GROUND_MATERIAL_MAP;

    static {
        GROUND_MATERIAL_MAP = ArrayListMultimap.create();
        for (Underlay underlay : values()) {
            for (Integer id : underlay.ids) {
                GROUND_MATERIAL_MAP.put(id, underlay);
            }
        }
    }

    public static Underlay getUnderlay(int underlayId, Tile tile, Client client, HdPluginConfig pluginConfig) {
        WorldPoint worldPoint = tile.getWorldLocation();

        if (client.isInInstancedRegion()) {
            LocalPoint localPoint = tile.getLocalLocation();
            worldPoint = WorldPoint.fromLocalInstance(client, localPoint);
        }

        int worldX = worldPoint.getX();
        int worldY = worldPoint.getY();
        int worldZ = worldPoint.getPlane();

        List<Underlay> underlays = GROUND_MATERIAL_MAP.get(underlayId);
        for (Underlay underlay : underlays) {
            if (underlay.area.containsPoint(worldX, worldY, worldZ)) {
                if (underlay.replacementCondition != null && underlay.replacementCondition.apply(pluginConfig)) {
                    return underlay.replacementUnderlay;
                }
                return underlay;
            }
        }

        return Underlay.NONE;
    }

}
