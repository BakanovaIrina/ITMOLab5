package InputOutputModule;

import CollectionModule.BaseClass.*;

/**
 * Класс, реализующий конвертацию
 */
public class InputConverter implements InputConverterAction {
    @Override
    public String[] convertToCommand(String s) {
        String[] commandArgs = s.replaceAll("(\t| )+", " ")
                .replaceAll("^ | $", "")
                .split(" ");
        if(commandArgs[0] != null){
            commandArgs[0].toLowerCase();
        }
        return commandArgs;
    }

    @Override
    public String convertToString(String s) {
        return s.toLowerCase();
    }

    @Override
    public int convertToInt(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }

    @Override
    public float convertToFloat(String s) throws NumberFormatException {
        return Float.parseFloat(s);
    }

    @Override
    public double convertToDouble(String s) throws NumberFormatException {
        return Double.parseDouble(s);
    }

    @Override
    public AstartesCategory convertToAstartesCategory(String s) throws IllegalArgumentException {
        return AstartesCategory.valueOf(s.toUpperCase());
    }

    @Override
    public MeleeWeapon convertToMeleeWeapon(String s) throws IllegalArgumentException {
        return MeleeWeapon.valueOf(s.toUpperCase());
    }

    @Override
    public Weapon convertToWeapon(String s) throws IllegalArgumentException {
        return Weapon.valueOf(s.toUpperCase());
    }
}
