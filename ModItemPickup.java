public class ModItemPickup extends ModDraggable{

	private ScreenPosition pos = ScreenPosition.fromRelativePosition(0.5, 0.5);
	// stores the itemstack and how long they have been on screen
	private HashMap<ItemStack, Integer> items = new HashMap<ItemStack, Integer>();
	// stores the stacksizes because the passed in itemstack has a stacksize of 0
	private ArrayList<Integer> stackSizes = new ArrayList<Integer>();
	
	public ModItemPickup()
	{
		EventManager.register(this);
	}
	
	@Override
	public int getWidth() {
		return 120;
	}

	@Override
	public int getHeight() {
		return 80;
	}

	@Override
	public void render(ScreenPosition pos) {
		int i = 0;
		Iterator it = items.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry itItem = (Map.Entry)it.next();
			ItemStack item = (ItemStack)itItem.getKey();
			font.drawString(item.getDisplayName() + " x" + stackSizes.get(i), pos.getAbsoluteX(), font.FONT_HEIGHT * i + pos.getAbsoluteY(), -1);
			i++;
		}
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		font.drawString("Item Pickups", pos.getAbsoluteX() + 10, pos.getAbsoluteY() + 10, -1);
	}

	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}
	
	@EventTarget
	public void onItemPickup(ItemPickupEvent e)
	{
		// Max visible items, removes first item to make room for the next
		if(items.keySet().size() > 8)
		{
			Iterator it = items.entrySet().iterator();
			Map.Entry entry = (Map.Entry)it.next();
			items.remove(entry.getKey());
			stackSizes.remove(0);
		}
		// add the item and the display time
		items.put(e.item, 50);
		//for some reason the stacksize from the itemstack is 0 thats why i store them separately
		stackSizes.add(e.stackSize);
	}
	
	@EventTarget
	public void onTick(ClientTickEvent e)
	{
		int j = 0;
		Iterator it = items.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry item = (Map.Entry)it.next();
			// get item timer
			int i = (int)item.getValue();
			// check if timer has runout
			if(i < 0) {
				items.remove(item.getKey());
				stackSizes.remove(j);
			}
			// decrease item timer
			item.setValue(i - 1);
			j++;
		}
	}

}
