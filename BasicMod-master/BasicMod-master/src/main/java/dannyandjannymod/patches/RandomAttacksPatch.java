package dannyandjannymod.patches;

import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import dannyandjannymod.stances.TiltedStance;
import jdk.nashorn.internal.runtime.regexp.joni.constants.TargetInfo;

public class RandomAttacksPatch {
    @SpirePatch(clz = DamageAction.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {AbstractCreature.class, DamageInfo.class, AbstractGameAction.AttackEffect.class})
    public static class RandomAttacks {
        @SpirePostfixPatch
        public static void PostFix(DamageAction __instance, AbstractCreature target, DamageInfo damageInfo, AbstractGameAction.AttackEffect attackEffect) {
            if (__instance.source == AbstractDungeon.player && damageInfo.type == DamageInfo.DamageType.NORMAL && AbstractDungeon.player.stance.ID.equals(TiltedStance.STANCE_ID))
            //if (__instance.source == AbstractDungeon.player && __instance.damageType == DamageInfo.DamageType.NORMAL && __instance.target instanceof AbstractMonster)
                __instance.target = AbstractDungeon.getCurrRoom().monsters.getRandomMonster((AbstractMonster)null, true, AbstractDungeon.cardRandomRng);
        }
    }

}
