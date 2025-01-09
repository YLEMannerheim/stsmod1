package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.stances.AbstractStance;
import dannyandjannymod.stances.DepressedStance;
import dannyandjannymod.stances.TiltedStance;

public class MoodSwingAction extends AbstractGameAction {

    AbstractStance stance;
    public MoodSwingAction(AbstractStance currentStance) {
        this.duration = Settings.ACTION_DUR_FAST;
        stance = currentStance;
    }

    public void update() {
        if (stance.ID.equals(TiltedStance.STANCE_ID)) {
            addToBot(new ChangeStanceAction(DepressedStance.STANCE_ID));
        } else if (stance.ID.equals(DepressedStance.STANCE_ID)) {
            addToBot(new ChangeStanceAction(TiltedStance.STANCE_ID));
        } else {
            boolean b = AbstractDungeon.cardRandomRng.random(1) == 1;
            if (b)
                addToBot(new ChangeStanceAction(DepressedStance.STANCE_ID));
            else
                addToBot(new ChangeStanceAction(TiltedStance.STANCE_ID));
        }

        this.isDone = true;
    }
}