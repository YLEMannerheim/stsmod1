package dannyandjannymod;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;
import dannyandjannymod.cards.HangoverCard;
import dannyandjannymod.stances.DrunkStance;

public class DrunkAction extends AbstractGameAction {

    public DrunkAction() {
    }

    public void update() {
        if (AbstractDungeon.player.stance.ID.equals(DrunkStance.STANCE_ID))
            this.addToBot(new MakeTempCardInDiscardAction(new HangoverCard(), 1));
        else
            addToBot(new ChangeStanceAction(DrunkStance.STANCE_ID));

        this.isDone = true;
    }
}