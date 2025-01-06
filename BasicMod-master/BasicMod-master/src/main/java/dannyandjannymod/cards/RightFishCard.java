package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.actions.watcher.NotStanceCheckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.EmptyStanceEffect;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.orbs.VoicesOrb;
import dannyandjannymod.stances.ChilledStance;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class RightFishCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RightFishCard",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);


    public RightFishCard() {
        super(cardInfo);
        setBlock(5, 3);
        setMagic(1);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));

        if (p.flipHorizontal) {
            addToBot(new DrawCardAction(p, magicNumber));
            p.flipHorizontal = !p.flipHorizontal;
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RightFishCard();
    }
}