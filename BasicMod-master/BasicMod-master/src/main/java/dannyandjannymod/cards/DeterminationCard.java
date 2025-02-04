package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.vfx.combat.IntimidateEffect;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.PunchwallAction;
import dannyandjannymod.powers.DeterminationPower;
import dannyandjannymod.powers.KorvalePower;
import dannyandjannymod.stances.SuicidalStance;
import dannyandjannymod.stances.TiltedStance;
import dannyandjannymod.util.CardInfo;


import static dannyandjannymod.BasicMod.makeID;

public class DeterminationCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DeterminationCard",
            3,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public DeterminationCard() {
        super(cardInfo);
        setCostUpgrade(2);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ChangeStanceAction(TiltedStance.STANCE_ID));
        this.addToBot(new ApplyPowerAction(p, p, new DeterminationPower(p)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DeterminationCard();
    }
}