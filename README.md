How Spring Security handles HTTP requests using the SecurityFilterChain.

The main topics covered are:

- HTTP Basic Authentication
- In-memory users using UserDetailsService
- Password hashing using BCryptPasswordEncoder
- Authentication vs Authorization
- Endpoint Authorization using authorizeRequests()
- Protecting endpoints with authenticated()
- Protecting endpoints with hasAuthority()
- Using anyRequest() as a fallback rule
- Using mvcMatchers() to apply security rules to specific URL patterns
- Understanding URL patterns such as:
  - `*` for one path level
  - `**` for all path levels
  - `*/*/*` for a specific number of path levels
- Restricting rules by HTTP method using HttpMethod
- Understanding the difference between matcher and authorization rule
- Understanding controller prefix using @RequestMapping
- Basic awareness of regexMatchers() for regex-based URL matching

## Practical Takeaway

This project helped me understand how to secure different endpoints using roles, authorities, URL patterns, HTTP methods, and fallback security rules.
