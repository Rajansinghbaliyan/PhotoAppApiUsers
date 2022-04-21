package io.cherrytechnologies.photoappapiusers.utils


import org.modelmapper.ModelMapper
import org.modelmapper.ModelMapper.*
import org.modelmapper.convention.MatchingStrategies

private var modelMapper = ModelMapper().configuration.setMatchingStrategy(MatchingStrategies.STRICT)
