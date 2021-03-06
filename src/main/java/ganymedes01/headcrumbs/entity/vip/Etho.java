package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Etho extends VIPHandler {

	@Override
	protected ItemStack getItem(EntityCelebrity entity) {
		return new ItemStack(Blocks.redstone_torch);
	}

	@Override
	public void onSpawn(EntityCelebrity entity) {
		ItemStack axe = new ItemStack(Items.iron_axe);
		EnchantmentHelper.addRandomEnchantment(entity.getRNG(), axe, 1 + entity.getRNG().nextInt(30));
		axe.setStackDisplayName("Treetho's Choppa");

		entity.setCurrentItemOrArmor(0, axe);
	}
}