package org.brokers.guiders.web.essay;

import org.brokers.guiders.web.essay.payload.EssayForm;
import org.brokers.guiders.web.member.guider.Guider;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class EssayServiceTest {

    @Test
    void writeEssay() {
        EssayRepository essayRepository = mock(EssayRepository.class);
        EssayService essayService = new EssayService(essayRepository, new ModelMapper());

        //given
        Guider guider = mock(Guider.class);
        EssayForm essayForm = new EssayForm();

        essayForm.setTitle("title");
        essayForm.setContent("content");

        Essay essay = Essay.builder()
                .title(essayForm.getTitle())
                .content(essayForm.getContent())
                .writer(guider)
                .build();

        when(essayRepository.save(essay)).thenReturn(essay);

        //when
        essayService.writeEssay(essayForm, guider);

        //then
        Mockito.verify(essayRepository, Mockito.times(1)).save(essay);
    }

}