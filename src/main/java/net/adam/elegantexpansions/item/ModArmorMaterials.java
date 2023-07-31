package net.adam.elegantexpansions.item;

import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    INFUSED_DIAMOND("infused_diamond", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266649_) -> {
        p_266649_.put(ArmorItem.Type.BOOTS, 3);
        p_266649_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266649_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266649_.put(ArmorItem.Type.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ModItems.INFUSED_DIAMOND.get())),

    INFUSED_EMERALD("infused_emerald", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266649_) -> {
        p_266649_.put(ArmorItem.Type.BOOTS, 3);
        p_266649_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266649_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266649_.put(ArmorItem.Type.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ModItems.INFUSED_EMERALD.get())),

    INFUSED_RUBY("infused_ruby", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266649_) -> {
        p_266649_.put(ArmorItem.Type.BOOTS, 3);
        p_266649_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266649_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266649_.put(ArmorItem.Type.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ModItems.INFUSED_RUBY.get())),

    INFUSED_SAPPHIRE("infused_sapphire", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266649_) -> {
        p_266649_.put(ArmorItem.Type.BOOTS, 3);
        p_266649_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266649_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266649_.put(ArmorItem.Type.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ModItems.INFUSED_SAPPHIRE.get())),

    INFUSED_AMETHYST("infused_amethyst", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266649_) -> {
        p_266649_.put(ArmorItem.Type.BOOTS, 3);
        p_266649_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266649_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266649_.put(ArmorItem.Type.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ModItems.INFUSED_AMETHYST.get())),

    INFUSED_CITRINE("infused_citrine", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266649_) -> {
        p_266649_.put(ArmorItem.Type.BOOTS, 3);
        p_266649_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266649_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266649_.put(ArmorItem.Type.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ModItems.INFUSED_CITRINE.get())),

    INFUSED_TANZANITE("infused_tanzanite", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266649_) -> {
        p_266649_.put(ArmorItem.Type.BOOTS, 3);
        p_266649_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266649_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266649_.put(ArmorItem.Type.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ModItems.INFUSED_TANZANITE.get())),

    INFUSED_ONYX("infused_onyx", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266649_) -> {
        p_266649_.put(ArmorItem.Type.BOOTS, 3);
        p_266649_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266649_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266649_.put(ArmorItem.Type.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ModItems.INFUSED_ONYX.get()));


    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionTypeMap,
                      int enchantmentValue, SoundEvent soundEvent, float toughness, float knockbackRes, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protectionTypeMap;
        this.enchantmentValue = enchantmentValue;
        this.sound = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackRes;
        this.repairIngredient = repairMaterial;
    }

    public int getDurabilityForType(ArmorItem.Type p_266745_) {
        return HEALTH_FUNCTION_FOR_TYPE.get(p_266745_) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type p_266752_) {
        return this.protectionFunctionForType.get(p_266752_);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return ElegantExpansions.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    /**
     * Gets the percentage of knockback resistance provided by armor of the material.
     */
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return ElegantExpansions.MOD_ID + ":" + this.name;
    }
}