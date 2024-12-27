package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.relics.BreakfastRelic;

public class RankedgameAction extends AbstractGameAction {

    public RankedgameAction() {
    }

    public void update() {
        if (AbstractDungeon.player.stance.ID.equals("Wrath")) {
            addToBot(new ChangeStanceAction("Divinity"));
        } else {
            addToBot(new ChangeStanceAction("Wrath"));
        }

        this.isDone = true;
    }
}