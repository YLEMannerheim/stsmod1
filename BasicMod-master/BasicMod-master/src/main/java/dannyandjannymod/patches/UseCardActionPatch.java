package dannyandjannymod.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import com.megacrit.cardcrawl.stances.AbstractStance;
import dannyandjannymod.cards.CuteStrikeCard;
import dannyandjannymod.orbs.KidOrb;
import dannyandjannymod.orbs.PusheenOrb;
import dannyandjannymod.stances.*;
import javassist.CtBehavior;

import java.util.Iterator;

public class UseCardActionPatch {
    @SpirePatch(clz = UseCardAction.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {AbstractCard.class, AbstractCreature.class})
    public static class KidHook {
        public static void Postfix() {
            //if (c.dontTriggerOnUseCard)
            //    return;
            AbstractPlayer p = AbstractDungeon.player;

            if (p.orbs.isEmpty())
                return;

            for (AbstractOrb o : p.orbs)
                if (o instanceof KidOrb)
                    ((KidOrb) o).onPlayCard();

            if (p.hasRelic("Cables") && !(p.orbs.get(0) instanceof EmptyOrbSlot) && AbstractDungeon.player.orbs.get(0) instanceof KidOrb)
                ((KidOrb)p.orbs.get(0)).onPlayCard();
        }
    }
}
