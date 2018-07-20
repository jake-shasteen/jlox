package lox;

import java.util.HashMap;
import java.util.Map;

class Environment {
  private final Map<String, Object> values = new HashMap<>();

  void define(String name, Object value) {
    values.put(name, value);
  }

  Object get(Token variableNameToken) {
    if (values.containsKey(variableNameToken.lexeme)) {
      return values.get(variableNameToken.lexeme);
    }

    throw new RuntimeError(variableNameToken,
      "Undefined variable " + variableNameToken.lexeme + " on line " + variableNameToken.line + "'.'");
  }

  void assign(Token name, Object value) {
    if (values.containsKey(name.lexeme)) {
      values.put(name.lexeme, value);
      return;
    }

    throw new RuntimeError(name,
      "Undefined variable " + name.lexeme + ".");
  }
}