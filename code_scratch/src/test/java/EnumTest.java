import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import test.enumtest.Direction;
import test.enumtest.Operation;

@Slf4j
public class EnumTest {
    @Test
    public void test() {
        for(Direction d : Direction.values()) {
            log.info("{} = {}",d.name(), d.getValue());
        }

        Direction d1 = Direction.EAST;
        Direction d2 = Direction.of(2);

        log.info("d1 : name : {}, symbol : {}", d1.name(), d1.getSymbol());
        log.info("d2 : name : {}, symbol : {}", d2.name(), d2.getSymbol());

        log.info(Direction.EAST.rotate(1).toString());
        log.info(Direction.EAST.rotate(2).toString());
        log.info(Direction.EAST.rotate(-1).toString());
        log.info(Direction.EAST.rotate(-1).toString());
    }

    @Test
    public void test2() {
        int x = 10;
        int y = 5;

        log.info("Addition: {}", Operation.ADD.apply(x, y));
        log.info("Subtraction: {}", Operation.SUBTRACT.apply(x, y));
        log.info("Multiplication: {}", Operation.MULTIPLY.apply(x, y));
        log.info("Division: {}", Operation.DIVIDE.apply(x, y));
    }
}
