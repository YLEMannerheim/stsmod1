package dannyandjannymod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.stances.AbstractStance;
import dannyandjannymod.stances.*;

public class StartTurnPostDrawStancePatch {
    @SpirePatch(clz = AbstractPlayer.class, method = "applyStartOfTurnPostDrawRelics")
    public static class DepressionCostChange {
        public static void Prefix() {
            if (AbstractDungeon.player.stance.ID.equals(DepressedStance.STANCE_ID))
                DepressedStance.atStartOfTurnPostDraw();
        }
    }
}
