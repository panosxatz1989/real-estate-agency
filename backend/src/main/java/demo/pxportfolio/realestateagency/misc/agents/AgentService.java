package demo.pxportfolio.realestateagency.misc.agents;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final ModelMapper modelMapper;
    private final AgentRepository agentRepository;

    public List<AgentDto> getAllAgents() {
        return agentRepository.findAll()
                .stream()
                .map(agent -> modelMapper.map(agent, AgentDto.class))
                .collect(Collectors.toList());
    }

    public AgentDto getAgentById(Long id) {
        Agent existingAgent = agentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(Agent.class.getSimpleName(), id.toString()));
        return modelMapper.map(existingAgent, AgentDto.class);
    }

    public List<ListDto> getAllAgentsList() {
        return agentRepository.findAll()
                .stream()
                .map(ListDto::new)
                .collect(Collectors.toList());
    }
}