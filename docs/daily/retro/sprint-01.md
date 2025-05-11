```md
🔁 Sprint 回顾（每阶段 1 周）→ Projects 看板 + retro 文档
每完成一批任务，就输出一篇 docs/retro/sprint-01.md：
md
复制代码
# Sprint 01 回顾

✅ 完成：
- 登录功能
- 查看好友空间

🐞 遇到问题：
- 日期类型不匹配（Date ↔ LocalDateTime）
- Session 缺失导致 Thymeleaf NPE

🧠 学习：
- session 对象要由 Controller 保证不为 null
