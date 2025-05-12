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

3. 

## optimization:

## Reflection:
