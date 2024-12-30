package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.relics.BreakfastRelic;
import dannyandjannymod.stances.SuicidalStance;
import dannyandjannymod.stances.TiltedStance;

public class RankedgameAction extends AbstractGameAction {

    public RankedgameAction() {
    }

    public void update() {
        if (AbstractDungeon.player.stance.ID.equals(TiltedStance.STANCE_ID)) {
            addToBot(new ChangeStanceAction(SuicidalStance.STANCE_ID));
            this.addToBot(new TalkAction(true, "AAAAAAAAHHH!", 1.0F, 2.0F));
        } else {
            addToBot(new ChangeStanceAction(TiltedStance.STANCE_ID));
            this.addToBot(new TalkAction(true, "Fuck this game!", 1.0F, 2.0F));
        }

        this.isDone = true;
    }
}