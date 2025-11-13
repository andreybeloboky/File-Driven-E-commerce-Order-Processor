package discount;

import exception.NotFoundCorrectInformationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DiscountFactory {

    private static final String SPLIT = "=";
    private static final String ALARM_ERROR_MESSAGE = "There are not suitable discount strategies, provided strategy %s";

    public static DiscountStrategy createDiscountStrategy(Path configFilePath) {
        ArrayList<String> values = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(configFilePath);
            for (String line : lines) {
                if (line.contains(SPLIT)) {
                    String[] s = line.split(SPLIT);
                    values.add(s[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createDiscount(values);
    }

    private static DiscountStrategy createDiscount(ArrayList<String> values) {
        try {
            String strategy = values.get(0);
            StrategyCommand command = StrategyCommand.valueOf(strategy);
            return switch (command) {
                case PERCENTAGE -> new PercentageDiscount(Double.parseDouble(values.get(1)));
                case NONE -> new NoDiscount();
                case FIXED -> new FixedAmountDiscount(Double.parseDouble(values.get(1)));
            };
        } catch (IllegalArgumentException e) {
            throw new NotFoundCorrectInformationException(ALARM_ERROR_MESSAGE.formatted(values.getFirst()), e.getCause());
        }
    }
}
