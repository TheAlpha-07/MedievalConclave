package medievalconclave.medievalconclave.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class ConditionEnchantment extends Enchantment {
    public ConditionEnchantment(Rarity p_i46731_1_, EnchantmentType p_i46731_2_, EquipmentSlotType... p_i46731_3_) {
        super(p_i46731_1_, p_i46731_2_, p_i46731_3_);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public ITextComponent getFullname(int p_200305_1_) {
        IFormattableTextComponent iformattabletextcomponent = new TranslationTextComponent(this.getDescriptionId());

        iformattabletextcomponent.withStyle(TextFormatting.GOLD);

        if (p_200305_1_ != 1 || this.getMaxLevel() != 1) {
            iformattabletextcomponent.append(" ").append(new TranslationTextComponent("enchantment.level." + p_200305_1_));
        }

        return iformattabletextcomponent;
    }



    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return false;
    }
}
