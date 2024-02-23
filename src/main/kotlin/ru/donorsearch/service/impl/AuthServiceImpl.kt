//package ru.taskmanager.service.impl
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.stereotype.Service
//import ru.donorsearch.model.dto.user.GetUserDto
//import ru.donorsearch.model.dto.user.UserDto
//import ru.taskmanager.model.mapper.UserMapper
//import ru.donorsearch.repository.UserRepository
//import ru.donorsearch.service.AuthService
//import ru.taskmanager.tool.JwtUtils
//import org.springframework.security.core.userdetails.User as AuthUser
//
//@Service
//class AuthServiceImpl(
//    private val userRepository: UserRepository,
//    private val userMapper: UserMapper,
//    private val passwordEncoder: PasswordEncoder,
//    private val jwtUtils: JwtUtils
//) : AuthService, UserDetailsService {
//
//    override fun login(username: String): String {
//        val foundUser = loadUserByUsername(username)
//        return jwtUtils.generateToken(foundUser)
//    }
//
//    override fun register(userDto: UserDto, username: String, password: String): GetUserDto {
//        var user = userMapper.createUser(userDto, username, password)
//        user.password = passwordEncoder.encode(user.password)
//        user = userRepository.save(user)
//        return GetUserDto(user.id, user.firstname, user.lastname, user.email, user.role)
//    }
//
//    override fun loadUserByUsername(username: String): UserDetails {
//        val user = userRepository.findUserByUsername(username).get()
//        val authorities: MutableList<SimpleGrantedAuthority> = ArrayList()
//        authorities.add(SimpleGrantedAuthority(user.role.toString()))
//        return AuthUser(user.username, user.password, authorities)
//    }
//}