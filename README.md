# ModItemPickup

Mod that adds a list of picked up itemstacks with the stack size. Uses Eric's draggable hud base and event manager.

Important!

> In EntityItem.java in onCollideWithPlayer add `new ItemPickupEvent(itemstack, i).call();` after `entityIn.onItemPickup(this, i);`

Usage:

Add both classes to your workspace, add the thing above and register in ModInstances.

Optional: Tweak max displayed items and display time to preference.(see comments in code)

This isnt the most elegant solution and may throw the occasional error but nothing breaks it as far as I know. Feel free to optimize or make a pull request/issue.
