#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class SharedInjectorCommon, SharedDataAccessContextArg, SharedDomainCharacter, SharedUtilitiesResponse<__covariant T>, SharedMvvm_coreViewModel, SharedCharactersListState, SharedMvvm_livedataMutableLiveData<T>, SharedErrorGetCharacterListState, SharedLoadingGetCharacterListState, SharedSuccessGetCharacterListState, SharedMvvm_livedataLiveData<T>, SharedKodein_diDIContext<C>, SharedKodein_diDITrigger, SharedKodein_diDIKey<__contravariant C, __contravariant A, __covariant T>, SharedKotlinUnit, SharedKodein_diDIContextCompanion, SharedKodein_typeTypeToken<T>, SharedKodein_diDIDefinition<C, A, T>, SharedKotlinTriple<__covariant A, __covariant B, __covariant C>, SharedKodein_diSearchSpecs, SharedKodein_typeTypeTokenCompanion, SharedKotlinArray<T>, SharedKodein_diDIDefining<C, A, T>, SharedKodein_diReferenceLocal<__covariant T, __covariant R>, SharedKodein_diReferenceLocalCompanion, SharedKodein_diScopeRegistry;

@protocol SharedKotlinx_coroutines_coreCoroutineScope, SharedKodein_diDI, SharedKotlinCoroutineContext, SharedKodein_diDIContainer, SharedKodein_diDIAware, SharedKotlinCoroutineContextElement, SharedKotlinCoroutineContextKey, SharedKodein_diDITree, SharedKodein_diReference, SharedKotlinLazy, SharedKodein_diContextTranslator, SharedKodein_diExternalSource, SharedKodein_diReferenceMaker, SharedKodein_diDIBinding, SharedKodein_diBindingDI, SharedKotlinIterator, SharedKodein_diDIBindingCopier, SharedKodein_diScope, SharedKodein_diBinding, SharedKodein_diDirectDI, SharedKodein_diDirectDIAware, SharedKodein_diDirectDIBase, SharedKodein_diWithContext, SharedKodein_diDIContainerBuilder, SharedKodein_diScopeCloseable;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface SharedBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface SharedBase (SharedBaseCopying) <NSCopying>
@end;

__attribute__((swift_name("KotlinMutableSet")))
@interface SharedMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((swift_name("KotlinMutableDictionary")))
@interface SharedMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorSharedKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((swift_name("KotlinNumber")))
@interface SharedNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinByte")))
@interface SharedByte : SharedNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((swift_name("KotlinUByte")))
@interface SharedUByte : SharedNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((swift_name("KotlinShort")))
@interface SharedShort : SharedNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((swift_name("KotlinUShort")))
@interface SharedUShort : SharedNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((swift_name("KotlinInt")))
@interface SharedInt : SharedNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((swift_name("KotlinUInt")))
@interface SharedUInt : SharedNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((swift_name("KotlinLong")))
@interface SharedLong : SharedNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((swift_name("KotlinULong")))
@interface SharedULong : SharedNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((swift_name("KotlinFloat")))
@interface SharedFloat : SharedNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((swift_name("KotlinDouble")))
@interface SharedDouble : SharedNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((swift_name("KotlinBoolean")))
@interface SharedBoolean : SharedNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("InjectorCommon")))
@interface SharedInjectorCommon : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)injectorCommon __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedInjectorCommon *shared __attribute__((swift_name("shared")));
- (SharedDataAccessContextArg * _Nullable)provideContextArgsContextArg:(SharedDataAccessContextArg *)contextArg __attribute__((swift_name("provideContextArgs(contextArg:)")));
@property SharedDataAccessContextArg * _Nullable context __attribute__((swift_name("context")));
@end;

__attribute__((swift_name("CharactersListState")))
@interface SharedCharactersListState : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (readonly) SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> * _Nullable response __attribute__((swift_name("response")));
@end;

__attribute__((swift_name("Mvvm_coreViewModel")))
@interface SharedMvvm_coreViewModel : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)onCleared __attribute__((swift_name("onCleared()")));
@property (readonly) id<SharedKotlinx_coroutines_coreCoroutineScope> viewModelScope __attribute__((swift_name("viewModelScope")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CharactersListViewModel")))
@interface SharedCharactersListViewModel : SharedMvvm_coreViewModel
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSString *)getData __attribute__((swift_name("getData()")));
- (void)getInformation __attribute__((swift_name("getInformation()")));
- (void)onCleared __attribute__((swift_name("onCleared()")));
@property SharedMvvm_livedataMutableLiveData<SharedCharactersListState *> *getCharactersLiveData __attribute__((swift_name("getCharactersLiveData")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ErrorGetCharacterListState")))
@interface SharedErrorGetCharacterListState : SharedCharactersListState
- (instancetype)initWithResponse:(SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> *)response __attribute__((swift_name("init(response:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> *)component1 __attribute__((swift_name("component1()")));
- (SharedErrorGetCharacterListState *)doCopyResponse:(SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> *)response __attribute__((swift_name("doCopy(response:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> *response __attribute__((swift_name("response")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LoadingGetCharacterListState")))
@interface SharedLoadingGetCharacterListState : SharedCharactersListState
- (instancetype)initWithResponse:(SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> * _Nullable)response __attribute__((swift_name("init(response:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> * _Nullable)component1 __attribute__((swift_name("component1()")));
- (SharedLoadingGetCharacterListState *)doCopyResponse:(SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> * _Nullable)response __attribute__((swift_name("doCopy(response:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> * _Nullable response __attribute__((swift_name("response")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SuccessGetCharacterListState")))
@interface SharedSuccessGetCharacterListState : SharedCharactersListState
- (instancetype)initWithResponse:(SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> *)response __attribute__((swift_name("init(response:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> *)component1 __attribute__((swift_name("component1()")));
- (SharedSuccessGetCharacterListState *)doCopyResponse:(SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> *)response __attribute__((swift_name("doCopy(response:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedUtilitiesResponse<NSArray<SharedDomainCharacter *> *> *response __attribute__((swift_name("response")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KodeInjectorKt")))
@interface SharedKodeInjectorKt : SharedBase
@property (class, readonly) id<SharedKodein_diDI> KodeinInjector __attribute__((swift_name("KodeinInjector")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DataAccessContextArg")))
@interface SharedDataAccessContextArg : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DomainCharacter")))
@interface SharedDomainCharacter : SharedBase
- (instancetype)initWithId:(int32_t)id name:(NSString *)name description:(NSString * _Nullable)description modified:(NSString * _Nullable)modified resourceURI:(NSString * _Nullable)resourceURI thumbnailPath:(NSString *)thumbnailPath urls:(NSString *)urls comics:(NSString *)comics stories:(NSString *)stories events:(NSString *)events series:(NSString *)series __attribute__((swift_name("init(id:name:description:modified:resourceURI:thumbnailPath:urls:comics:stories:events:series:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component10 __attribute__((swift_name("component10()")));
- (NSString *)component11 __attribute__((swift_name("component11()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString *)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (NSString *)component9 __attribute__((swift_name("component9()")));
- (SharedDomainCharacter *)doCopyId:(int32_t)id name:(NSString *)name description:(NSString * _Nullable)description modified:(NSString * _Nullable)modified resourceURI:(NSString * _Nullable)resourceURI thumbnailPath:(NSString *)thumbnailPath urls:(NSString *)urls comics:(NSString *)comics stories:(NSString *)stories events:(NSString *)events series:(NSString *)series __attribute__((swift_name("doCopy(id:name:description:modified:resourceURI:thumbnailPath:urls:comics:stories:events:series:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *comics __attribute__((swift_name("comics")));
@property (readonly) NSString * _Nullable description_ __attribute__((swift_name("description_")));
@property (readonly) NSString *events __attribute__((swift_name("events")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable modified __attribute__((swift_name("modified")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable resourceURI __attribute__((swift_name("resourceURI")));
@property (readonly) NSString *series __attribute__((swift_name("series")));
@property (readonly) NSString *stories __attribute__((swift_name("stories")));
@property (readonly) NSString *thumbnailPath __attribute__((swift_name("thumbnailPath")));
@property (readonly) NSString *urls __attribute__((swift_name("urls")));
@end;

__attribute__((swift_name("UtilitiesResponse")))
@interface SharedUtilitiesResponse<__covariant T> : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol SharedKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<SharedKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((swift_name("Mvvm_livedataLiveData")))
@interface SharedMvvm_livedataLiveData<T> : SharedBase
- (instancetype)initWithInitialValue:(T _Nullable)initialValue __attribute__((swift_name("init(initialValue:)"))) __attribute__((objc_designated_initializer));
- (void)addObserverObserver:(void (^)(T _Nullable))observer __attribute__((swift_name("addObserver(observer:)")));
- (void)changeValueValue:(T _Nullable)value __attribute__((swift_name("changeValue(value:)")));
- (void)removeObserverObserver:(void (^)(T _Nullable))observer __attribute__((swift_name("removeObserver(observer:)")));
@property (readonly) T _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("Mvvm_livedataMutableLiveData")))
@interface SharedMvvm_livedataMutableLiveData<T> : SharedMvvm_livedataLiveData<T>
- (instancetype)initWithInitialValue:(T _Nullable)initialValue __attribute__((swift_name("init(initialValue:)"))) __attribute__((objc_designated_initializer));
- (void)postValueValue:(T _Nullable)value __attribute__((swift_name("postValue(value:)")));
@property T _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("Kodein_diDIAware")))
@protocol SharedKodein_diDIAware
@required
@property (readonly) id<SharedKodein_diDI> di __attribute__((swift_name("di")));
@property (readonly) SharedKodein_diDIContext<id> *diContext __attribute__((swift_name("diContext")));
@property (readonly) SharedKodein_diDITrigger * _Nullable diTrigger __attribute__((swift_name("diTrigger")));
@end;

__attribute__((swift_name("Kodein_diDI")))
@protocol SharedKodein_diDI <SharedKodein_diDIAware>
@required
@property (readonly) id<SharedKodein_diDIContainer> container __attribute__((swift_name("container")));
@end;

__attribute__((swift_name("KotlinCoroutineContext")))
@protocol SharedKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<SharedKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<SharedKotlinCoroutineContextElement> _Nullable)getKey:(id<SharedKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<SharedKotlinCoroutineContext>)minusKeyKey:(id<SharedKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<SharedKotlinCoroutineContext>)plusContext:(id<SharedKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end;

__attribute__((swift_name("Kodein_diDIContainer")))
@protocol SharedKodein_diDIContainer
@required
- (NSArray<id (^)(id _Nullable)> *)allFactoriesKey:(SharedKodein_diDIKey<id, id, id> *)key context:(SharedKodein_diDIContext<id> *)context overrideLevel:(int32_t)overrideLevel __attribute__((swift_name("allFactories(key:context:overrideLevel:)")));
- (NSArray<id (^)(void)> *)allProvidersKey:(SharedKodein_diDIKey<id, SharedKotlinUnit *, id> *)key context:(SharedKodein_diDIContext<id> *)context overrideLevel:(int32_t)overrideLevel __attribute__((swift_name("allProviders(key:context:overrideLevel:)")));
- (id (^)(id _Nullable))factoryKey:(SharedKodein_diDIKey<id, id, id> *)key context:(SharedKodein_diDIContext<id> *)context overrideLevel:(int32_t)overrideLevel __attribute__((swift_name("factory(key:context:overrideLevel:)")));
- (id (^ _Nullable)(id _Nullable))factoryOrNullKey:(SharedKodein_diDIKey<id, id, id> *)key context:(SharedKodein_diDIContext<id> *)context overrideLevel:(int32_t)overrideLevel __attribute__((swift_name("factoryOrNull(key:context:overrideLevel:)")));
- (id (^)(void))providerKey:(SharedKodein_diDIKey<id, SharedKotlinUnit *, id> *)key context:(SharedKodein_diDIContext<id> *)context overrideLevel:(int32_t)overrideLevel __attribute__((swift_name("provider(key:context:overrideLevel:)")));
- (id (^ _Nullable)(void))providerOrNullKey:(SharedKodein_diDIKey<id, SharedKotlinUnit *, id> *)key context:(SharedKodein_diDIContext<id> *)context overrideLevel:(int32_t)overrideLevel __attribute__((swift_name("providerOrNull(key:context:overrideLevel:)")));
@property (readonly) id<SharedKodein_diDITree> tree __attribute__((swift_name("tree")));
@end;

__attribute__((swift_name("Kodein_diDIContext")))
@interface SharedKodein_diDIContext<C> : SharedBase
@property (class, readonly, getter=companion) SharedKodein_diDIContextCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) id<SharedKodein_diReference> reference __attribute__((swift_name("reference")));
@property (readonly) SharedKodein_typeTypeToken<C> *type __attribute__((swift_name("type")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kodein_diDITrigger")))
@interface SharedKodein_diDITrigger : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)trigger __attribute__((swift_name("trigger()")));
@property (readonly) NSMutableArray<id<SharedKotlinLazy>> *properties __attribute__((swift_name("properties")));
@end;

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol SharedKotlinCoroutineContextElement <SharedKotlinCoroutineContext>
@required
@property (readonly) id<SharedKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol SharedKotlinCoroutineContextKey
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kodein_diDIKey")))
@interface SharedKodein_diDIKey<__contravariant C, __contravariant A, __covariant T> : SharedBase
- (instancetype)initWithContextType:(SharedKodein_typeTypeToken<C> *)contextType argType:(SharedKodein_typeTypeToken<A> *)argType type:(SharedKodein_typeTypeToken<T> *)type tag:(id _Nullable)tag __attribute__((swift_name("init(contextType:argType:type:tag:)"))) __attribute__((objc_designated_initializer));
- (SharedKodein_typeTypeToken<C> *)component1 __attribute__((swift_name("component1()")));
- (SharedKodein_typeTypeToken<A> *)component2 __attribute__((swift_name("component2()")));
- (SharedKodein_typeTypeToken<T> *)component3 __attribute__((swift_name("component3()")));
- (id _Nullable)component4 __attribute__((swift_name("component4()")));
- (SharedKodein_diDIKey<C, A, T> *)doCopyContextType:(SharedKodein_typeTypeToken<C> *)contextType argType:(SharedKodein_typeTypeToken<A> *)argType type:(SharedKodein_typeTypeToken<T> *)type tag:(id _Nullable)tag __attribute__((swift_name("doCopy(contextType:argType:type:tag:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedKodein_typeTypeToken<A> *argType __attribute__((swift_name("argType")));
@property (readonly) NSString *bindDescription __attribute__((swift_name("bindDescription")));
@property (readonly) NSString *bindFullDescription __attribute__((swift_name("bindFullDescription")));
@property (readonly) SharedKodein_typeTypeToken<C> *contextType __attribute__((swift_name("contextType")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@property (readonly) NSString *fullDescription __attribute__((swift_name("fullDescription")));
@property (readonly) NSString *internalDescription __attribute__((swift_name("internalDescription")));
@property (readonly) id _Nullable tag __attribute__((swift_name("tag")));
@property (readonly) SharedKodein_typeTypeToken<T> *type __attribute__((swift_name("type")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface SharedKotlinUnit : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinUnit *shared __attribute__((swift_name("shared")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Kodein_diDITree")))
@protocol SharedKodein_diDITree
@required
- (NSArray<SharedKotlinTriple<SharedKodein_diDIKey<id, id, id> *, SharedKodein_diDIDefinition<id, id, id> *, id<SharedKodein_diContextTranslator>> *> *)findKey:(SharedKodein_diDIKey<id, id, id> *)key overrideLevel:(int32_t)overrideLevel all:(BOOL)all __attribute__((swift_name("find(key:overrideLevel:all:)")));
- (NSArray<SharedKotlinTriple<SharedKodein_diDIKey<id, id, id> *, NSArray<SharedKodein_diDIDefinition<id, id, id> *> *, id<SharedKodein_diContextTranslator>> *> *)findSearch:(SharedKodein_diSearchSpecs *)search __attribute__((swift_name("find(search:)")));
- (SharedKotlinTriple<SharedKodein_diDIKey<id, id, id> *, NSArray<SharedKodein_diDIDefinition<id, id, id> *> *, id<SharedKodein_diContextTranslator>> * _Nullable)getKey_:(SharedKodein_diDIKey<id, id, id> *)key __attribute__((swift_name("get(key_:)")));
@property (readonly) NSDictionary<SharedKodein_diDIKey<id, id, id> *, NSArray<SharedKodein_diDIDefinition<id, id, id> *> *> *bindings __attribute__((swift_name("bindings")));
@property (readonly) NSArray<id<SharedKodein_diExternalSource>> *externalSources __attribute__((swift_name("externalSources")));
@property (readonly) NSArray<id<SharedKodein_diContextTranslator>> *registeredTranslators __attribute__((swift_name("registeredTranslators")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kodein_diDIContextCompanion")))
@interface SharedKodein_diDIContextCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKodein_diDIContextCompanion *shared __attribute__((swift_name("shared")));
- (SharedKodein_diDIContext<id> *)invokeType:(SharedKodein_typeTypeToken<id> *)type getContext:(id (^)(void))getContext refMaker:(id<SharedKodein_diReferenceMaker>)refMaker __attribute__((swift_name("invoke(type:getContext:refMaker:)")));
- (SharedKodein_diDIContext<id> *)invokeType:(SharedKodein_typeTypeToken<id> *)type getReference:(id<SharedKodein_diReference> (^)(void))getReference __attribute__((swift_name("invoke(type:getReference:)")));
- (SharedKodein_diDIContext<id> *)invokeType:(SharedKodein_typeTypeToken<id> *)type context:(id)context refMaker:(id<SharedKodein_diReferenceMaker>)refMaker __attribute__((swift_name("invoke(type:context:refMaker:)")));
- (SharedKodein_diDIContext<id> *)invokeType:(SharedKodein_typeTypeToken<id> *)type reference:(id<SharedKodein_diReference>)reference __attribute__((swift_name("invoke(type:reference:)")));
@property (readonly) SharedKodein_diDIContext<id> *Any __attribute__((swift_name("Any")));
@end;

__attribute__((swift_name("Kodein_diReference")))
@protocol SharedKodein_diReference
@required
- (id _Nullable)get __attribute__((swift_name("get()")));
@property (readonly) id<SharedKodein_diReferenceMaker> maker __attribute__((swift_name("maker")));
@end;

__attribute__((swift_name("Kodein_typeTypeToken")))
@interface SharedKodein_typeTypeToken<T> : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKodein_typeTypeTokenCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (SharedKotlinArray<SharedKodein_typeTypeToken<id> *> *)getGenericParameters __attribute__((swift_name("getGenericParameters()")));
- (SharedKodein_typeTypeToken<T> * _Nullable)getRaw __attribute__((swift_name("getRaw()")));
- (NSArray<SharedKodein_typeTypeToken<id> *> *)getSuper __attribute__((swift_name("getSuper()")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)isAssignableFromTypeToken:(SharedKodein_typeTypeToken<id> *)typeToken __attribute__((swift_name("isAssignableFrom(typeToken:)")));
- (BOOL)isGeneric __attribute__((swift_name("isGeneric()")));
- (BOOL)isWildcard __attribute__((swift_name("isWildcard()")));
- (NSString *)qualifiedDispString __attribute__((swift_name("qualifiedDispString()")));
- (NSString *)qualifiedErasedDispString __attribute__((swift_name("qualifiedErasedDispString()")));
- (NSString *)simpleDispString __attribute__((swift_name("simpleDispString()")));
- (NSString *)simpleErasedDispString __attribute__((swift_name("simpleErasedDispString()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("KotlinLazy")))
@protocol SharedKotlinLazy
@required
- (BOOL)isInitialized __attribute__((swift_name("isInitialized()")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("Kodein_diDIDefining")))
@interface SharedKodein_diDIDefining<C, A, T> : SharedBase
- (instancetype)initWithBinding:(id<SharedKodein_diDIBinding>)binding fromModule:(NSString * _Nullable)fromModule __attribute__((swift_name("init(binding:fromModule:)"))) __attribute__((objc_designated_initializer));
@property (readonly) id<SharedKodein_diDIBinding> binding __attribute__((swift_name("binding")));
@property (readonly) NSString * _Nullable fromModule __attribute__((swift_name("fromModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kodein_diDIDefinition")))
@interface SharedKodein_diDIDefinition<C, A, T> : SharedKodein_diDIDefining<C, A, T>
- (instancetype)initWithBinding:(id<SharedKodein_diDIBinding>)binding fromModule:(NSString * _Nullable)fromModule tree:(id<SharedKodein_diDITree>)tree __attribute__((swift_name("init(binding:fromModule:tree:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithBinding:(id<SharedKodein_diDIBinding>)binding fromModule:(NSString * _Nullable)fromModule __attribute__((swift_name("init(binding:fromModule:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (readonly) id<SharedKodein_diDITree> tree __attribute__((swift_name("tree")));
@end;

__attribute__((swift_name("Kodein_diContextTranslator")))
@protocol SharedKodein_diContextTranslator
@required
- (id _Nullable)translateCtx:(id)ctx __attribute__((swift_name("translate(ctx:)")));
@property (readonly) SharedKodein_typeTypeToken<id> *contextType __attribute__((swift_name("contextType")));
@property (readonly) SharedKodein_typeTypeToken<id> *scopeType __attribute__((swift_name("scopeType")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinTriple")))
@interface SharedKotlinTriple<__covariant A, __covariant B, __covariant C> : SharedBase
- (instancetype)initWithFirst:(A _Nullable)first second:(B _Nullable)second third:(C _Nullable)third __attribute__((swift_name("init(first:second:third:)"))) __attribute__((objc_designated_initializer));
- (A _Nullable)component1 __attribute__((swift_name("component1()")));
- (B _Nullable)component2 __attribute__((swift_name("component2()")));
- (C _Nullable)component3 __attribute__((swift_name("component3()")));
- (SharedKotlinTriple<A, B, C> *)doCopyFirst:(A _Nullable)first second:(B _Nullable)second third:(C _Nullable)third __attribute__((swift_name("doCopy(first:second:third:)")));
- (BOOL)equalsOther:(id _Nullable)other __attribute__((swift_name("equals(other:)")));
- (int32_t)hashCode __attribute__((swift_name("hashCode()")));
- (NSString *)toString __attribute__((swift_name("toString()")));
@property (readonly) A _Nullable first __attribute__((swift_name("first")));
@property (readonly) B _Nullable second __attribute__((swift_name("second")));
@property (readonly) C _Nullable third __attribute__((swift_name("third")));
@end;

__attribute__((swift_name("Kodein_diSearchSpecs")))
@interface SharedKodein_diSearchSpecs : SharedBase
- (instancetype)initWithContextType:(SharedKodein_typeTypeToken<id> * _Nullable)contextType argType:(SharedKodein_typeTypeToken<id> * _Nullable)argType type:(SharedKodein_typeTypeToken<id> * _Nullable)type tag:(id _Nullable)tag __attribute__((swift_name("init(contextType:argType:type:tag:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property SharedKodein_typeTypeToken<id> * _Nullable argType __attribute__((swift_name("argType")));
@property SharedKodein_typeTypeToken<id> * _Nullable contextType __attribute__((swift_name("contextType")));
@property id _Nullable tag __attribute__((swift_name("tag")));
@property SharedKodein_typeTypeToken<id> * _Nullable type __attribute__((swift_name("type")));
@end;

__attribute__((swift_name("Kodein_diExternalSource")))
@protocol SharedKodein_diExternalSource
@required
- (id (^ _Nullable)(id _Nullable))getFactoryDi:(id<SharedKodein_diBindingDI>)di key:(SharedKodein_diDIKey<id, id, id> *)key __attribute__((swift_name("getFactory(di:key:)")));
@end;

__attribute__((swift_name("Kodein_diReferenceMaker")))
@protocol SharedKodein_diReferenceMaker
@required
- (SharedKodein_diReferenceLocal<id, id<SharedKodein_diReference>> *)makeCreator:(id (^)(void))creator __attribute__((swift_name("make(creator:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kodein_typeTypeTokenCompanion")))
@interface SharedKodein_typeTypeTokenCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKodein_typeTypeTokenCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) SharedKodein_typeTypeToken<id> *Any __attribute__((swift_name("Any")));
@property (readonly) SharedKodein_typeTypeToken<SharedKotlinUnit *> *Unit __attribute__((swift_name("Unit")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface SharedKotlinArray<T> : SharedBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(SharedInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<SharedKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kodein_diBinding")))
@protocol SharedKodein_diBinding
@required
- (id (^)(id _Nullable))getFactoryDi:(id<SharedKodein_diBindingDI>)di key_:(SharedKodein_diDIKey<id, id, id> *)key __attribute__((swift_name("getFactory(di:key_:)")));
@end;

__attribute__((swift_name("Kodein_diDIBinding")))
@protocol SharedKodein_diDIBinding <SharedKodein_diBinding>
@required
- (NSString *)factoryFullName __attribute__((swift_name("factoryFullName()")));
- (NSString *)factoryName __attribute__((swift_name("factoryName()")));
@property (readonly) SharedKodein_typeTypeToken<id> *argType __attribute__((swift_name("argType")));
@property (readonly) SharedKodein_typeTypeToken<id> *contextType __attribute__((swift_name("contextType")));
@property (readonly) id<SharedKodein_diDIBindingCopier> _Nullable copier __attribute__((swift_name("copier")));
@property (readonly) SharedKodein_typeTypeToken<id> *createdType __attribute__((swift_name("createdType")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@property (readonly) NSString *fullDescription __attribute__((swift_name("fullDescription")));
@property (readonly) id<SharedKodein_diScope> _Nullable scope __attribute__((swift_name("scope")));
@property (readonly) BOOL supportSubTypes __attribute__((swift_name("supportSubTypes")));
@end;

__attribute__((swift_name("Kodein_diDirectDIAware")))
@protocol SharedKodein_diDirectDIAware
@required
@property (readonly) id<SharedKodein_diDirectDI> directDI __attribute__((swift_name("directDI")));
@end;

__attribute__((swift_name("Kodein_diDirectDIBase")))
@protocol SharedKodein_diDirectDIBase <SharedKodein_diDirectDIAware>
@required
- (id (^)(id _Nullable))FactoryArgType:(SharedKodein_typeTypeToken<id> *)argType type:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag __attribute__((swift_name("Factory(argType:type:tag:)")));
- (id (^ _Nullable)(id _Nullable))FactoryOrNullArgType:(SharedKodein_typeTypeToken<id> *)argType type:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag __attribute__((swift_name("FactoryOrNull(argType:type:tag:)")));
- (id)InstanceType:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag __attribute__((swift_name("Instance(type:tag:)")));
- (id)InstanceArgType:(SharedKodein_typeTypeToken<id> *)argType type:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag arg:(id _Nullable)arg __attribute__((swift_name("Instance(argType:type:tag:arg:)")));
- (id _Nullable)InstanceOrNullType:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag __attribute__((swift_name("InstanceOrNull(type:tag:)")));
- (id _Nullable)InstanceOrNullArgType:(SharedKodein_typeTypeToken<id> *)argType type:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag arg:(id _Nullable)arg __attribute__((swift_name("InstanceOrNull(argType:type:tag:arg:)")));
- (id<SharedKodein_diDirectDI>)OnContext:(SharedKodein_diDIContext<id> *)context __attribute__((swift_name("On(context:)")));
- (id (^)(void))ProviderType:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag __attribute__((swift_name("Provider(type:tag:)")));
- (id (^)(void))ProviderArgType:(SharedKodein_typeTypeToken<id> *)argType type:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag arg:(id _Nullable (^)(void))arg __attribute__((swift_name("Provider(argType:type:tag:arg:)")));
- (id (^ _Nullable)(void))ProviderOrNullType:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag __attribute__((swift_name("ProviderOrNull(type:tag:)")));
- (id (^ _Nullable)(void))ProviderOrNullArgType:(SharedKodein_typeTypeToken<id> *)argType type:(SharedKodein_typeTypeToken<id> *)type tag:(id _Nullable)tag arg:(id _Nullable (^)(void))arg __attribute__((swift_name("ProviderOrNull(argType:type:tag:arg:)")));
@property (readonly) id<SharedKodein_diDIContainer> container __attribute__((swift_name("container")));
@property (readonly) id<SharedKodein_diDI> di __attribute__((swift_name("di")));
@property (readonly) id<SharedKodein_diDI> lazy __attribute__((swift_name("lazy")));
@end;

__attribute__((swift_name("Kodein_diDirectDI")))
@protocol SharedKodein_diDirectDI <SharedKodein_diDirectDIBase>
@required
@end;

__attribute__((swift_name("Kodein_diWithContext")))
@protocol SharedKodein_diWithContext
@required
@property (readonly) id context __attribute__((swift_name("context")));
@end;

__attribute__((swift_name("Kodein_diBindingDI")))
@protocol SharedKodein_diBindingDI <SharedKodein_diDirectDI, SharedKodein_diWithContext>
@required
- (id<SharedKodein_diBindingDI>)noGlobalContext __attribute__((swift_name("noGlobalContext()")));
- (id (^)(id _Nullable))overriddenFactory __attribute__((swift_name("overriddenFactory()")));
- (id (^ _Nullable)(id _Nullable))overriddenFactoryOrNull __attribute__((swift_name("overriddenFactoryOrNull()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kodein_diReferenceLocal")))
@interface SharedKodein_diReferenceLocal<__covariant T, __covariant R> : SharedBase
- (instancetype)initWithValue:(T)value reference:(R)reference __attribute__((swift_name("init(value:reference:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKodein_diReferenceLocalCompanion *companion __attribute__((swift_name("companion")));
- (T)component1 __attribute__((swift_name("component1()")));
- (R)component2 __attribute__((swift_name("component2()")));
- (SharedKodein_diReferenceLocal<T, R> *)doCopyValue:(T)value reference:(R)reference __attribute__((swift_name("doCopy(value:reference:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) R reference __attribute__((swift_name("reference")));
@property (readonly) T value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol SharedKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("Kodein_diDIBindingCopier")))
@protocol SharedKodein_diDIBindingCopier
@required
- (id<SharedKodein_diDIBinding>)doCopyBuilder:(id<SharedKodein_diDIContainerBuilder>)builder __attribute__((swift_name("doCopy(builder:)")));
@end;

__attribute__((swift_name("Kodein_diScope")))
@protocol SharedKodein_diScope
@required
- (SharedKodein_diScopeRegistry *)getRegistryContext:(id _Nullable)context __attribute__((swift_name("getRegistry(context:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kodein_diReferenceLocalCompanion")))
@interface SharedKodein_diReferenceLocalCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKodein_diReferenceLocalCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("Kodein_diDIContainerBuilder")))
@protocol SharedKodein_diDIContainerBuilder
@required
- (void)bindKey:(SharedKodein_diDIKey<id, id, id> *)key binding:(id<SharedKodein_diDIBinding>)binding fromModule:(NSString * _Nullable)fromModule overrides:(SharedBoolean * _Nullable)overrides __attribute__((swift_name("bind(key:binding:fromModule:overrides:)")));
- (void)extendContainer:(id<SharedKodein_diDIContainer>)container allowOverride:(BOOL)allowOverride copy:(NSSet<SharedKodein_diDIKey<id, id, id> *> *)copy __attribute__((swift_name("extend(container:allowOverride:copy:)")));
- (void)onReadyCb:(void (^)(id<SharedKodein_diDirectDI>))cb __attribute__((swift_name("onReady(cb:)")));
- (void)registerContextTranslatorTranslator:(id<SharedKodein_diContextTranslator>)translator __attribute__((swift_name("registerContextTranslator(translator:)")));
- (id<SharedKodein_diDIContainerBuilder>)subBuilderAllowOverride:(BOOL)allowOverride silentOverride:(BOOL)silentOverride __attribute__((swift_name("subBuilder(allowOverride:silentOverride:)")));
@end;

__attribute__((swift_name("Kodein_diScopeCloseable")))
@protocol SharedKodein_diScopeCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end;

__attribute__((swift_name("Kodein_diScopeRegistry")))
@interface SharedKodein_diScopeRegistry : SharedBase <SharedKodein_diScopeCloseable>
- (void)clear __attribute__((swift_name("clear()")));
- (void)close __attribute__((swift_name("close()")));
- (id)getOrCreateKey:(id)key sync:(BOOL)sync creator:(SharedKodein_diReferenceLocal<id, id<SharedKodein_diReference>> *(^)(void))creator __attribute__((swift_name("getOrCreate(key:sync:creator:)")));
- (id<SharedKodein_diReference> _Nullable)getOrNullKey:(id)key __attribute__((swift_name("getOrNull(key:)")));
- (void)removeKey:(id)key __attribute__((swift_name("remove(key:)")));
- (id)values __attribute__((swift_name("values()")));
@end;

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
