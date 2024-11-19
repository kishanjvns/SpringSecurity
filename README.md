# SpringSecurity
This repo will test the different different approaches of spring security in separate branches

In this branch defaultSpringHttpConfigManually we used two approach to configure the spring based http basic security 
Class DefaultSecurityConfig and DefaultSecurityConfigV2
this DefaultSecurityConfig used the bean of every spring security components and the spring automatically inject those bean into the dependent components

The other class DefaultSecurityConfigV2 is also implemented the same thing but here the approach to implement is bit different here instead creating bean of each component I have directly configure them into the HttpSecurity object

prior to spring 3.X

public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception{
httpSecurity.httpBasic(Customizer.withDefaults());
httpSecurity.authorizeHttpRequests(c-> c.anyRequest().authenticated());
return httpSecurity.build();
}
The above piece of code can be written as a chain of method as below

public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception{
httpSecurity.httpBasic(Customizer.withDefaults());
httpSecurity.authorizeHttpRequests()
    .anyRequest()
    .authenticated();
return httpSecurity.build();
}