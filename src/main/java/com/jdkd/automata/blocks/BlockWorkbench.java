package com.jdkd.automata.blocks;

import com.jdkd.automata.AutomataMain;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockWorkbench extends BlockContainer {

    public BlockWorkbench() {
        super(Material.WOOD);
        setRegistryName("workbench_automata");
        setUnlocalizedName("workbench_automata");
        setCreativeTab(AutomataMain.tab);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }
}
