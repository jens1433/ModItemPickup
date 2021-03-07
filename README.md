# ModItemPickup

Mod that adds a list of picked up itemstacks with the stack size. Uses Eric's draggable hud base and event manager.

In EntityItem.java in onCollideWithPlayer add `new ItemPickupEvent(itemstack, i).call();` after `entityIn.onItemPickup(this, i);` and register in `ModInstances` of course
