package com.jdkd.automata.entities.automaton;

import com.jdkd.automata.items.parts.AutomatonAttributeModifier;
import com.jdkd.automata.items.parts.AutomatonPart;
import com.jdkd.automata.items.parts.AutomatonPartType;
import com.jdkd.automata.items.parts.arms.AutomatonArm;
import com.jdkd.automata.items.parts.head.AutomatonHead;
import com.jdkd.automata.items.parts.legs.AutomatonLeg;
import com.jdkd.automata.items.parts.shell.AutomatonShell;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class EntityAutomata extends EntityGolem {

    private static final DataParameter<ItemStack> BODY_TYPE = EntityDataManager.<ItemStack>createKey(EntityAutomata.class, DataSerializers.ITEM_STACK);
    private static final DataParameter<ItemStack> HEAD_TYPE = EntityDataManager.<ItemStack>createKey(EntityAutomata.class, DataSerializers.ITEM_STACK);
    private static final DataParameter<ItemStack> ARM_TYPE = EntityDataManager.<ItemStack>createKey(EntityAutomata.class, DataSerializers.ITEM_STACK);
    private static final DataParameter<ItemStack> LEG_TYPE = EntityDataManager.<ItemStack>createKey(EntityAutomata.class, DataSerializers.ITEM_STACK);

    private Map<AutomatonPartType, AutomatonPart> parts;
    private boolean isDirty;

    public EntityAutomata(World worldIn, AutomatonPart shell) {
        this(worldIn);
        setItem(shell);
    }

    public EntityAutomata(World worldIn) {
        super(worldIn);

        setSize(0.25f, 0.25f);
        parts = new HashMap<>();
        isDirty = true;
    }

    @Override
    protected void initEntityAI() {
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);

        if(parts != null) {
            for (AutomatonPart part : parts.values()) {
                for (AutomatonAttributeModifier modifier : part.getAttributeModifiers()) {
                    modifier.modifyAttribute(this);
                }
            }
        }

    }

    @Override
    protected int decreaseAirSupply(int air) {
        return air;
    }

    @Override
    public EnumActionResult applyPlayerInteraction(EntityPlayer player, Vec3d vec, EnumHand hand) {

        ItemStack stack = player.getHeldItem(hand);

        if (stack != null && stack.getItem() != null) {
            if (stack.getItem() instanceof AutomatonPart) {
                setItem((AutomatonPart) stack.getItem());
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                applyEntityAttributes();
                markDirty();
            }
        }

        return super.applyPlayerInteraction(player, vec, hand);
    }

    public void setItem(AutomatonPart part) {
        switch (part.getPartType()) {
            case BODY:
                this.getDataManager().set(BODY_TYPE, new ItemStack((Item) part));
                this.getDataManager().setDirty(BODY_TYPE);
                break;
            case HEAD:
                this.getDataManager().set(HEAD_TYPE, new ItemStack((Item) part));
                this.getDataManager().setDirty(HEAD_TYPE);
                break;
            case ARM:
                this.getDataManager().set(ARM_TYPE, new ItemStack((Item) part));
                this.getDataManager().setDirty(ARM_TYPE);
                break;
            case LEG:
                this.getDataManager().set(LEG_TYPE, new ItemStack((Item) part));
                this.getDataManager().setDirty(LEG_TYPE);
                break;
        }

        parts.put(part.getPartType(), part);
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        ItemStack head = new ItemStack(compound.getCompoundTag(AutomatonPartType.HEAD.name()));
        ItemStack body = new ItemStack(compound.getCompoundTag(AutomatonPartType.BODY.name()));
        ItemStack arm = new ItemStack(compound.getCompoundTag(AutomatonPartType.ARM.name()));
        ItemStack leg = new ItemStack(compound.getCompoundTag(AutomatonPartType.LEG.name()));

        if (!head.isEmpty()) {
            this.setItem((AutomatonPart) head.getItem());
        }
        if (!body.isEmpty()) {
            this.setItem((AutomatonPart) body.getItem());
        }
        if (!arm.isEmpty()) {
            this.setItem((AutomatonPart) arm.getItem());
        }
        if (!leg.isEmpty()) {
            this.setItem((AutomatonPart) leg.getItem());
        }
    }

    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        ItemStack head = this.getPart(AutomatonPartType.HEAD);
        ItemStack body = this.getPart(AutomatonPartType.BODY);
        ItemStack arm = this.getPart(AutomatonPartType.ARM);
        ItemStack leg = this.getPart(AutomatonPartType.LEG);

        if (!head.isEmpty()) {
            compound.setTag(AutomatonPartType.HEAD.name(), head.writeToNBT(new NBTTagCompound()));
        }
        if (!body.isEmpty()) {
            compound.setTag(AutomatonPartType.BODY.name(), body.writeToNBT(new NBTTagCompound()));
        }
        if (!arm.isEmpty()) {
            compound.setTag(AutomatonPartType.ARM.name(), arm.writeToNBT(new NBTTagCompound()));
        }
        if (!leg.isEmpty()) {
            compound.setTag(AutomatonPartType.LEG.name(), leg.writeToNBT(new NBTTagCompound()));
        }
    }

    public ItemStack getPart(AutomatonPartType type) {

        ItemStack itemStack = null;

        switch (type) {
            case BODY:
                itemStack = this.getDataManager().get(BODY_TYPE);
                break;
            case HEAD:
                itemStack = this.getDataManager().get(HEAD_TYPE);
                break;
            case ARM:
                itemStack = this.getDataManager().get(ARM_TYPE);
                break;
            case LEG:
                itemStack = this.getDataManager().get(LEG_TYPE);
                break;
        }

        return itemStack;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(BODY_TYPE, ItemStack.EMPTY);
        this.getDataManager().register(HEAD_TYPE, ItemStack.EMPTY);
        this.getDataManager().register(ARM_TYPE, ItemStack.EMPTY);
        this.getDataManager().register(LEG_TYPE, ItemStack.EMPTY);
    }

    public Map<AutomatonPartType, AutomatonPart> getAutomatonParts() {
        if (this.getDataManager().get(BODY_TYPE) != null && parts.get(AutomatonPartType.BODY) == null) {
            Item body = this.getDataManager().get(BODY_TYPE).getItem();
            if (body instanceof AutomatonPart) {
                parts.put(AutomatonPartType.BODY, (AutomatonPart) body);
            }
        }
        if (this.getDataManager().get(HEAD_TYPE) != null && parts.get(AutomatonPartType.HEAD) == null) {
            Item body = this.getDataManager().get(HEAD_TYPE).getItem();
            if (body instanceof AutomatonPart) {
                parts.put(AutomatonPartType.HEAD, (AutomatonPart) body);
            }
        }
        if (this.getDataManager().get(ARM_TYPE) != null && parts.get(AutomatonPartType.ARM) == null) {
            Item body = this.getDataManager().get(ARM_TYPE).getItem();
            if (body instanceof AutomatonPart) {
                parts.put(AutomatonPartType.ARM, (AutomatonPart) body);
            }
        }
        if (this.getDataManager().get(LEG_TYPE) != null && parts.get(AutomatonPartType.LEG) == null) {
            Item body = this.getDataManager().get(LEG_TYPE).getItem();
            if (body instanceof AutomatonPart) {
                parts.put(AutomatonPartType.LEG, (AutomatonPart) body);
            }
        }
        return parts;
    }

    public AutomatonHead getHead(){
        AutomatonPart automatonPart = getAutomatonPart(AutomatonPartType.HEAD);
        return automatonPart != null ? (AutomatonHead) automatonPart : null;
    }

    public AutomatonShell getShell(){
        AutomatonPart automatonPart = getAutomatonPart(AutomatonPartType.BODY);
        return automatonPart != null ? (AutomatonShell) automatonPart : null;    }

    public AutomatonArm getArm(){
        AutomatonPart automatonPart = getAutomatonPart(AutomatonPartType.ARM);
        return automatonPart != null ? (AutomatonArm) automatonPart : null;    }

    public AutomatonLeg getLeg(){
        AutomatonPart automatonPart = getAutomatonPart(AutomatonPartType.LEG);
        return automatonPart != null ? (AutomatonLeg) automatonPart : null;    }

    private AutomatonPart getAutomatonPart(AutomatonPartType partType){
        return parts.get(partType);
    }

    public boolean isDirty(){
        return isDirty;
    }

    public void clean(){
        isDirty = false;
    }

    private void markDirty(){
        isDirty = true;
    }
}
