package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;
import dannyandjannymod.cards.DentedBucketCard;

import java.util.Iterator;
import java.util.UUID;

public class DentedBucketAction extends AbstractGameAction {
    private int miscIncrease;
    private UUID uuid;

    private int baseDamage;

    public DentedBucketAction(UUID targetUUID, int miscIncrease) {
        this.miscIncrease = miscIncrease;
        this.uuid = targetUUID;
        this.duration = 0.1f;
    }

    public void update() {
        Iterator var1 = AbstractDungeon.player.masterDeck.group.iterator();


        AbstractCard c;
        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c.uuid.equals(this.uuid)) {
                c.misc += this.miscIncrease;
                c.applyPowers();
                c.baseDamage = Math.max(0, c.upgraded ? c.misc + DentedBucketCard.UPG_DAMAGE: c.misc);
                c.isDamageModified = false;
            }
        }

        for(var1 = GetAllInBattleInstances.get(this.uuid).iterator(); var1.hasNext(); c.baseDamage = Math.max(0, c.upgraded ? c.misc + DentedBucketCard.UPG_DAMAGE : c.misc)) {
            c = (AbstractCard)var1.next();
            c.misc += this.miscIncrease;
            c.applyPowers();
        }

        this.isDone = true;
    }
}
