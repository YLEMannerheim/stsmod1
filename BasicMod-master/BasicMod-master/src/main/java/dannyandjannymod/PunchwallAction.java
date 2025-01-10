package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.stances.ChilledStance;
import dannyandjannymod.stances.SuicidalStance;
import dannyandjannymod.stances.TiltedStance;

public class PunchwallAction extends AbstractGameAction {

    public PunchwallAction() {
    }

    public void update() {
        if (AbstractDungeon.player.stance.ID.equals(TiltedStance.STANCE_ID)) {
            addToBot(new ChangeStanceAction(ChilledStance.STANCE_ID));
            this.addToBot(new TalkAction(true, "Time to cooldown", 1.0F, 2.0F));
        }

        this.isDone = true;
    }
}