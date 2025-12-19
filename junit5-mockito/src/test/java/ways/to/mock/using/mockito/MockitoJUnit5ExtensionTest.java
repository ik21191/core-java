package ways.to.mock.using.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MockitoJUnit5ExtensionTest {

  @Mock
  CalculatorService mockService;

  @InjectMocks
  Calculator calculator;

  @Test
  void testMockitoJUnit5Extension() {
    // Define mock behavior
    when(mockService.add(3, 7)).thenReturn(10);

    // Verify the result
    int result = calculator.calculateSum(3, 7);
    assertEquals(10, result);
  }

  static class Calculator {
    private final CalculatorService service;

    Calculator(CalculatorService service) {
      this.service = service;
    }

    int calculateSum(int a, int b) {
      System.out.println("dummy result is " + service.dummy());
      return service.add(a, b);
    }
  }

  interface CalculatorService {
    int add(int a, int b);
    int dummy();
  }
}

