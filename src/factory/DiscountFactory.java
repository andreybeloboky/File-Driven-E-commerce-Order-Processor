package factory;

import strategy.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DiscountFactory {

    public static DiscountStrategy careateDiscountStrategy(Path configFilePath) {
        ArrayList<String> values = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(configFilePath);
            for (String line : lines) {
                if (line.contains("=")) {
                    String[] s = line.split("=");
                    values.add(s[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StrategyCommand command = StrategyCommand.valueOf(values.get(0));
        return switch (command) {
            case PERCENTAGE -> new PercentageDiscount(Double.parseDouble(values.get(1)));
            case NONE -> new NoDiscount();
            case FIXED -> new FixedAmountDiscount(Double.parseDouble(values.get(1)));
        };
    }
}
