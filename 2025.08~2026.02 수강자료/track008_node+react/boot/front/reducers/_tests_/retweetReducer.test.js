import reducer, {
  addRetweetRequest, addRetweetSuccess, addRetweetFailure,
  removeRetweetRequest, removeRetweetSuccess, removeRetweetFailure,
  hasRetweetedRequest, hasRetweetedSuccess, hasRetweetedFailure,
  fetchMyRetweetsRequest, fetchMyRetweetsSuccess, fetchMyRetweetsFailure,
} from '../retweetReducer'

describe('like reducer', ()=>{

const initialState = {  retweets: {},         retweetsCount: {},    loading: false,  error: null,
};

    //리트윗
    it(('addRetweetSuccess'), ()=>{
        const state =reducer(initialState, addRetweetSuccess({postId:1, retweetCount:5}));
        expect(state.retweets[1]).toBe(true);
        expect(state.retweetsCount[1]).toBe(5);
    });

    //리트윗 삭제
    it(('removeRetweetSuccess'), ()=>{
        const prev = {...initialState, retweets:{1:true}, retweetsCount:{1:5}};
        const state =reducer(prev,  removeRetweetSuccess({postId:1, retweetCount:4}));
        expect(state.retweets[1]).toBe(false);
        expect(state.retweetsCount[1]).toBe(4);
    });

    //특정 게시글에 내가 리트윗했는지
    it(('hasRetweetedSuccess'), ()=>{
        const state =reducer(initialState,  hasRetweetedSuccess({postId:1, hasRetweeted:true}));
        expect(state.retweets[1]).toBe(true);
    });

    // 내가 리트윗한 전체 글목록
    it(('fetchMyRetweetsSuccess'), ()=>{
        const state =reducer(initialState,  fetchMyRetweetsSuccess({1:true, 2:true}));
        expect(state.retweets[1]).toBe(true);
        expect(state.retweets[2]).toBe(true);
    });
});