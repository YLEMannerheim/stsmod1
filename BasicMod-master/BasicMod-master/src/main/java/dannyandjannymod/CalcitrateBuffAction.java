//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.blue.Claw;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.cards.CalcitrateCard;
import dannyandjannymod.cards.EmptyBottleCard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.ILoggerFactory;
import sun.security.util.Debug;

import java.util.Iterator;

public class CalcitrateBuffAction extends AbstractGameAction {


    public CalcitrateBuffAction(int amount) {
        this.amount = amount;
    }

    public void update() {
        Debug d = new Debug();
        d.println("Triggered! BUFFING CALCITRATE");

        Iterator var1 = AbstractDungeon.player.discardPile.group.iterator();

        AbstractCard c;
        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c instanceof CalcitrateCard) {
                c.baseDamage += this.amount;
                //c.applyPowers();
            }
        }

        var1 = AbstractDungeon.player.drawPile.group.iterator();

        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c instanceof CalcitrateCard) {
                c.baseDamage += this.amount;
                //c.applyPowers();
            }
        }

        var1 = AbstractDungeon.player.hand.group.iterator();

        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c instanceof CalcitrateCard) {
                c.baseDamage += this.amount;
                c.applyPowers();
            }
        }

        this.isDone = true;
    }
}
