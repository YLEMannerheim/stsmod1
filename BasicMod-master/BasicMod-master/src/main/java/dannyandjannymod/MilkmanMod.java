package dannyandjannymod;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.ISubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.CardLibrary;

import static basemod.BaseMod.addColor;


@SpireInitializer
public class MilkmanMod implements EditCharactersSubscriber {

    public MilkmanMod() {
        //BaseMod.subscribeToEditCharacters(this);
        BaseMod.subscribe(this);

        addColor(AbstractCardEnum.MILKMAN_WHITE, Color.LIGHT_GRAY, ATTACK_BG, SKILL_BG, POWER_BG, ENERGY_ORB, ATTACK_BG_PORT, SKILL_BG_PORT, POWER_BG_PORT, ENERGY_ORB_PORT, ENERGY_ORB_CARD);

    }

    public static void initialize() {
        MilkmanMod mod = new MilkmanMod();
    }

    public static final String MY_CHARACTER_BUTTON = "dannyandjannymod/character/char_button.png";
    public static final String MY_CHARACTER_PORTRAIT = "dannyandjannymod/character/char_button.png";
    public static final String POWER_BG = "dannyandjannymod/character/char_button.png";
    public static final String ATTACK_BG = "dannyandjannymod/character/char_button.png";
    public static final String SKILL_BG = "dannyandjannymod/character/char_button.png";
    public static final String POWER_BG_PORT = "dannyandjannymod/character/char_button.png";
    public static final String ATTACK_BG_PORT = "dannyandjannymod/character/char_button.png";
    public static final String SKILL_BG_PORT = "dannyandjannymod/character/char_button.png";
    public static final String ENERGY_ORB = "dannyandjannymod/character/char_button.png";
    public static final String ENERGY_ORB_PORT = "dannyandjannymod/character/char_button.png";
    public static final String ENERGY_ORB_CARD = "dannyandjannymod/character/char_button.png";


    @Override
    public void receiveEditCharacters() {
        //logger.info("begin editing characters");
        //logger.info("add " + MilkmanClassEnum.MILKMAN.toString());


        BaseMod.addCharacter(new MilkmanCharacter(CardCrawlGame.playerName),
                MY_CHARACTER_BUTTON,
                MY_CHARACTER_PORTRAIT,
                MilkmanClassEnum.MILKMAN_WHITE);

        //addColor(AbstractCardEnum.MILKMAN_WHITE, Color.LIGHT_GRAY, ATTACK_BG, SKILL_BG, POWER_BG, ENERGY_ORB, ATTACK_BG_PORT, SKILL_BG_PORT, POWER_BG_PORT, ENERGY_ORB_PORT, ENERGY_ORB_CARD);

        //logger.info("done editing characters");
    }

}