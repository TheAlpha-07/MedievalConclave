package medievalconclave.medievalconclave.item.custom;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import net.minecraft.item.Item;

public class Dissuader extends SwordBaseItem {


    public Dissuader(Item.Properties properties, WeaponMaterial materialIn, float weaponBaseDamage, float weaponDamageMultiplier, double weaponSpeed, String customDisplayName, boolean usingDeferredRegister, WeaponTrait... weaponTraits) {
        super(customDisplayName, properties, materialIn, weaponBaseDamage, weaponDamageMultiplier, weaponSpeed, usingDeferredRegister, weaponTraits);
    }

}
