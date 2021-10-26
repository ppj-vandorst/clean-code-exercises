package src.errorHandling;

public class Worker {

    public void validateInput(String input) {
        boolean isValid = Service.isValid(input);

        if (!isValid) {
            throw new RuntimeException("error");
        }
    }

    public void validateInput2(String input) {
        try {
            Service.isValid(input);
        } catch (ExceptionA e) {
            // do stuff
        } catch (ExceptionB e) {
            // do stuff
        } catch (ExceptionC e) {
            // do stuff
        } catch (ExceptionD e) {
            // do stuff
        }
    }
}
