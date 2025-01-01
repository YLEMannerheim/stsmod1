package dannyandjannymod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.cards.CuteStrikeCard;
import dannyandjannymod.orbs.PusheenOrb;
import java.util.Iterator;

public class CuteStrikePatch {
    @SpirePatch(clz = PusheenOrb.class, method = SpirePatch.CONSTRUCTOR)
    public static class CheckPusheenChannel {
        public static void Prefix() {
            AbstractCard card;
            Iterator it;
            it = AbstractDungeon.player.discardPile.group.iterator();
            while(it.hasNext()) {
                card = (AbstractCard)it.next();
                if (card instanceof CuteStrikeCard)
                    card.baseDamage += CuteStrikeCard.INCREASE;
            }

            it = AbstractDungeon.player.drawPile.group.iterator();
            while(it.hasNext()) {
                card = (AbstractCard)it.next();
                if (card instanceof CuteStrikeCard)
                    card.baseDamage += CuteStrikeCard.INCREASE;
            }

            it = AbstractDungeon.player.hand.group.iterator();
            while(it.hasNext()) {
                card = (AbstractCard)it.next();
                if (card instanceof CuteStrikeCard)
                    card.baseDamage += CuteStrikeCard.INCREASE;
            }
        }
    }

}
