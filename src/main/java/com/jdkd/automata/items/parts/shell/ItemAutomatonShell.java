package com.jdkd.automata.items.parts.shell;

import com.jdkd.automata.entities.automaton.EntityAutomata;
import com.jdkd.automata.items.parts.AbstractAutomatonPart;
import com.jdkd.automata.items.parts.AutomatonMaterial;
import com.jdkd.automata.items.parts.AutomatonPart;
import com.jdkd.automata.items.parts.AutomatonPartType;
import com.jdkd.automata.utils.MaterialUtil;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemAutomatonShell extends AbstractAutomatonPart implements AutomatonShell {

    private List<ModelRenderer> modelRenderer;
    private int maxUpgrades;

    public ItemAutomatonShell(AutomatonMaterial material) {
        super(material);
    }

    @Override
    public AutomatonPartType getPartType() {
        return AutomatonPartType.BODY;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (worldIn.isRemote) {
            return EnumActionResult.SUCCESS;
        } else if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
            return EnumActionResult.FAIL;
        }

        BlockPos blockpos = pos.offset(facing);
        double d0 = this.getYOffset(worldIn, blockpos);
        Entity entity = spawnCreature(worldIn, (double) blockpos.getX() + 0.5D, (double) blockpos.getY() + d0, (double) blockpos.getZ() + 0.5D);

        if (entity != null) {
            if (entity instanceof EntityLivingBase && itemstack.hasDisplayName()) {
                entity.setCustomNameTag(itemstack.getDisplayName());
            }

            if (!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }
        }

        return EnumActionResult.SUCCESS;
    }

    protected double getYOffset(World worldIn, BlockPos pos) {
        AxisAlignedBB axisalignedbb = (new AxisAlignedBB(pos)).expand(0.0D, -1.0D, 0.0D);
        List<AxisAlignedBB> list = worldIn.getCollisionBoxes((Entity) null, axisalignedbb);

        if (list.isEmpty()) {
            return 0.0D;
        } else {
            double d0 = axisalignedbb.minY;

            for (AxisAlignedBB axisalignedbb1 : list) {
                d0 = Math.max(axisalignedbb1.maxY, d0);
            }

            return d0 - (double) pos.getY();
        }
    }

    @Nullable
    public Entity spawnCreature(World worldIn, double x, double y, double z) {
        Entity entity = null;

        for (int i = 0; i < 1; ++i) {
            entity = new EntityAutomata(worldIn, this);

            if (entity instanceof EntityLiving) {
                EntityLiving entityliving = (EntityLiving) entity;
                entity.setLocationAndAngles(x, y, z, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
                entityliving.rotationYawHead = entityliving.rotationYaw;
                entityliving.renderYawOffset = entityliving.rotationYaw;
                entityliving.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData) null);
                worldIn.spawnEntity(entity);
                entityliving.playLivingSound();
            }
        }
        return entity;
    }

    @Override
    public int getMaxUpgrades() {
        return maxUpgrades;
    }

    @Override
    public boolean canEquipPart(AutomatonPart part) {
        return part.getMaterial().ordinal() <= getMaterial().ordinal();
    }
}
