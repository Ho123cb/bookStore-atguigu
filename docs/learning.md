## Errors:
1. 在javaWeb项目中不能通过WEB-INF访问文件

2. 注意`${#seesion}`和`${seesion}`

   ## 🔍 一、`session` 和 `#session` 到底有什么区别？

   | 写法             | 含义                                                     | 解释                                                   |
   | ---------------- | -------------------------------------------------------- | ------------------------------------------------------ |
   | `${session.xxx}` | 直接访问 Servlet 的 session 中存的属性值（EL表达式风格） | 类似于 JSP 里的 `${sessionScope.xxx}`                  |
   | `#{...}`         | i18n 国际化资源文件解析                                  | 与这无关，不要混淆                                     |
   | `#session.xxx`   | Thymeleaf 内置对象 `#session`，它是 `HttpSession` 的映射 | 表示使用 Thymeleaf 自带的表达式对象访问 session 作用域 |
   | `session`        | 可能是一个你传入的模型变量名叫 session（容易混淆）       | 所以 Thymeleaf 推荐 `#session` 更清晰                  |

---



## optimization:

---

## Reflection:

1. 对于java基础的知识掌握太差，以及thymeleaf和html相关的用法都需求用再差导致效率底下

   解决： 着重复习集合、stream、lamda表达式，以及thymeleaf常用概念的区分

---

## newKnowlege：
1. 如何快速遍历一个`HashMap`容器？

​	✅ 方式一：使用 `entrySet()`（推荐方式 ✅）

```
java复制代码for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
    System.out.println(key + " = " + value);
}
```

### 📌 说明：

- `entrySet()` 返回的是一个包含键值对的 `Set<Map.Entry<K, V>>`
- 性能最好，因为直接访问键值对，不会额外调用 `get()`

### ✅ 推荐理由：

> 如果你要**同时使用 key 和 value**，这是最好的选择！

------

## ✅ 方式二：使用 `keySet()`（只要 key 或 get value）

```
java复制代码for (String key : map.keySet()) {
    Integer value = map.get(key);
    System.out.println(key + " = " + value);
}
```

### 📌 说明：

- `keySet()` 只遍历 key，然后每次都 `map.get(key)` 查 value
- 如果 HashMap 很大，这种方式性能稍差一点

### 🚫 不推荐用于大 map：

> 因为每次都 `get(key)` 是额外 O(1) 的操作，累计影响性能

------

## ✅ 方式三：使用 `values()` 遍历所有值（只要 value）

```
java复制代码for (Integer value : map.values()) {
    System.out.println("value = " + value);
}
```

### 📌 说明：

- 只适合你只关心 value 的情况

------

## ✅ 方式四：使用 Java 8 Lambda 表达式（简洁现代）

```
java复制代码map.forEach((key, value) -> {
    System.out.println(key + " -> " + value);
});
```

### 📌 说明：

- 从 Java 8 开始，`Map` 接口有了 `forEach` 方法
- 非常适合写在 lambda、stream 或 GUI 事件处理里

------

## ✅ 总结：选择哪种？

| 方式         | 适用场景                     | 性能  | 推荐度 |
| ------------ | ---------------------------- | ----- | ------ |
| `entrySet()` | 同时要 key 和 value          | ★★★★☆ | ✅✅✅✅   |
| `keySet()`   | 只处理 key（偶尔 get value） | ★★☆☆☆ | ✅✅     |
| `values()`   | 只处理 value                 | ★★★☆☆ | ✅✅✅    |
| `forEach()`  | 简洁语法（Java 8+）          | ★★★★☆ | ✅✅✅✅   |

2. 如何保留`double`类型的小数位到一位

   1. 用于展示：

      ```java
      double num = 3.14159;
      String result = String.format("%.1f", num);
      System.out.println(result); // 输出：3.1
      ```

   2. 定制展示

      ```java
      import java.text.DecimalFormat;
      
      double num = 3.14159;
      DecimalFormat df = new DecimalFormat("#.0");
      String result = df.format(num);
      System.out.println(result); // 输出：3.1
      ```

   3. 精度展示
      **core**：定义一个`BigDecimal`数，设计其格式，取出double值即可

      ```java
      import java.math.BigDecimal;
      import java.math.RoundingMode;
      
      double num = 3.14159;
      BigDecimal bd = new BigDecimal(num);
      double rounded = bd.setScale(1,RoundingMode.HALF_UP).doubleValue();
      System.out.println(rounded); // 输出：3.1
      ```

   4.  快速实现（简单）

      ```java
      double num = 3.14159;
      double rounded = Math.round(num * 10) / 10.0;
      System.out.println(rounded); // 输出：3.1
      ```

   5. 通过thymeleaf内部实现

      `#numbers.formatDecimal(book.price, 1, 1)`

   | 方法 | 返回类型 | 推荐场景 | 是否精确 |
   | ---- | -------- | -------- | -------- |
   |      |          |          |          |

   | `String.format()` | `String` | 页面展示/日志输出 | ✖（仅格式化） |
   | ----------------- | -------- | ----------------- | ------------- |
   |                   |          |                   |               |

   | `DecimalFormat` | `String` | 格式定制需求强时 | ✖    |
   | --------------- | -------- | ---------------- | ---- |
   |                 |          |                  |      |

   | `BigDecimal` | `double` / `BigDecimal` | 精度要求高 | ✅✅✅  |
   | ------------ | ----------------------- | ---------- | ---- |
   |              |                         |            |      |

   | `Math.round()` | `double` | 快速简单处理 | 一般 |
   | -------------- | -------- | ------------ | ---- |
   |                |          |              |      |

​		