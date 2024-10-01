package app_prosjekt;

import java.util.Iterator;

public class ScreenplayIterator implements Iterator<Screenplay>{
    private ScreenplayList screenplayList;
    private int index;

    public ScreenplayIterator(ScreenplayList screenplayList) {
        this.screenplayList = screenplayList;
        this.index = 0;
    }

    @Override
	public boolean hasNext() {
		return index < screenplayList.getScreenplayCount();
	}

	@Override
	public Screenplay next() {
		Screenplay screenplay = screenplayList.getScreenplay(index);
        index ++;
        return screenplay;
	}

}