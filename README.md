# ModItemPickup

Mod that adds a list of picked up itemstacks with the stack size.

In EntityItem.java in onCollideWithPlayer add '<new ItemPickupEvent(itemstack, i).call();>' after '<entityIn.onItemPickup(this, i);>'
