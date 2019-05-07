package io.devcken.kotring.category

import org.springframework.http.MediaType
import org.springframework.restdocs.payload.JsonFieldType
import io.devcken.kotring.spock.IntegrationSpec

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class CategoryControllerSpec extends IntegrationSpec {
    def 'GET /categories'() {
        expect:
        mockMvc.perform(get('/categories')
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(
                        document(
                                'categories',
                                preprocessRequest(modifyingUri, prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath('[].id').type(JsonFieldType.NUMBER).description('').optional(),
                                        fieldWithPath('[].name').type(JsonFieldType.STRING).description('').optional()
                                )
                        )
                )
    }
}
