package dannyandjannymod.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.stances.AbstractStance;
import dannyandjannymod.stances.*;

public class StancePatch {
    @SpirePatch(clz = AbstractStance.class, method = "getStanceFromName")
    public static class GetStanceFromName {
        public static SpireReturn<AbstractStance> Prefix(String stanceID) {
            if (stanceID.equals(TiltedStance.STANCE_ID))
                return SpireReturn.Return(new TiltedStance());
            if (stanceID.equals(DepressedStance.STANCE_ID))
                return SpireReturn.Return(new DepressedStance());
            if (stanceID.equals(AfkStance.STANCE_ID))
                return SpireReturn.Return(new AfkStance());
            if (stanceID.equals(ChilledStance.STANCE_ID))
                return SpireReturn.Return(new ChilledStance());
            if (stanceID.equals(DrunkStance.STANCE_ID))
                return SpireReturn.Return(new DrunkStance());
            if (stanceID.equals(SuicidalStance.STANCE_ID))
                return SpireReturn.Return(new SuicidalStance());

            return SpireReturn.Continue();
        }
    }
}
