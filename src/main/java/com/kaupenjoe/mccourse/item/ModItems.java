package com.kaupenjoe.mccourse.item;

import com.kaupenjoe.mccourse.MCCourseMod;
import com.kaupenjoe.mccourse.block.ModBlocks;
import com.kaupenjoe.mccourse.block.ModFluids;
import com.kaupenjoe.mccourse.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
                    () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_WIRE =
            Registration.ITEMS.register("copper_wire",
                    () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPERED_APPLE =
            Registration.ITEMS.register("coppered_apple",
                    () -> new CopperedApple());


    public static final RegistryObject<Item> COPPER_SHOVEL =
            Registration.ITEMS.register("copper_shovel",
                    () -> new ShovelItem(ModItemTier.COPPER, 0f, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.SHOVEL, 2)
                                    .group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_SWORD =
            Registration.ITEMS.register("copper_sword",
                    () -> new SwordItem(ModItemTier.COPPER, 2, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_PICKAXE =
            Registration.ITEMS.register("copper_pickaxe",
                    () -> new PickaxeItem(ModItemTier.COPPER, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 2)
                                    .group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_HOE =
            Registration.ITEMS.register("copper_hoe",
                    () -> new HoeItem(ModItemTier.COPPER, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.HOE, 2)
                                    .group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_AXE =
            Registration.ITEMS.register("copper_axe",
                    () -> new AxeItem(ModItemTier.COPPER, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.AXE, 2)
                                    .group(MCCourseMod.COURSE_TAB)));


    /* ARMOR */

    public static final RegistryObject<Item> COPPER_HELMET =
            Registration.ITEMS.register("copper_helmet",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD,
                        new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_CHESTPLATE =
            Registration.ITEMS.register("copper_chestplate",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_LEGGINGS =
            Registration.ITEMS.register("copper_leggings",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_BOOTS =
            Registration.ITEMS.register("copper_boots",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    /* CROPS */
    public static final RegistryObject<Item> ZUCCHINI_SEED =
            Registration.ITEMS.register("zucchini_seed",
                    () -> new  BlockItem(ModBlocks.ZUCCHINI_CROP.get(), new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    /* FLUIDS*/

    public static final RegistryObject<Item> OIL_BUCKET =
            Registration.ITEMS.register("oil_bucket",
                    () -> new BucketItem(ModFluids.OIL_FLUID::get,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB).maxStackSize(1)));


    public static void register()
    {
    }

    public enum ModArmorMaterial implements IArmorMaterial
    {
        COPPER(50, new int[] { 2, 7, 5, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())),
                MCCourseMod.MOD_ID + ":copper", 0, 0.1f);

        private final int durability;
        private final int[] damageReductioAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackResisteance;

        ModArmorMaterial(int durability, int[] damageReductioAmountArray, int enchantability,
                         SoundEvent soundEvent, Ingredient repairMaterial, String name, float toughness, float knockbackResisteance)
        {
            this.durability = durability;
            this.damageReductioAmountArray = damageReductioAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResisteance = knockbackResisteance;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn)
        {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn)
        {
            return damageReductioAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability()
        {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent()
        {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return repairMaterial;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public float getToughness()
        {
            return toughness;
        }

        @Override
        public float getKnockbackResistance()
        {
            return knockbackResisteance;
        }

    }

    public enum ModItemTier implements IItemTier
    {
        COPPER(2, 150, 2.5f, 0f, 15,
                Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMatereal;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage
                , int enchantability, Ingredient repairMaterial)
        {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMatereal = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMatereal;
        }
    }

}
