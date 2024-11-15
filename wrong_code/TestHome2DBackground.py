import re
def testHome2DBackground(key,type:int,backgroundList,backgroundSpeedList,deviation,horizonY,nightBackgroundList,nightBackgroundSpeedList,Unnamed):
    #key:对应背景id,字符串
    #type:背景类型，整数
    #backgroundList:背景资源列表，字符串形式
    #backgroundSpeedList:背景跟随移动速度比例
    #deviation:人物图片偏移
    #horizonY:地平线
    #nightBackgroundList:黑夜背景资源列表
    #nightBackgroundSpeedList:黑夜背景跟随移动速度比例
    #Unnamed:是否导表，字符串
    
    #背景资源列表字段中的资源必须存在，资源之间用“；”或“：”间隔        
    #支持背景多层级随机，则背景资源列表格式变为层级之间“;”间隔，随机资源之间":"间隔，背景跟随移动速度比例对应每一个背景资源
    #多个背景资源路径写的顺序代表背景层级，写越前面代表离玩家越近，比如有三个背景资源：资源路径1；资源路径2；资源路径3，则1是近景，2是中景，3是远景
    #多个背景跟随移动速度比例写的顺序代表背景层级，比如有三个数值：0.3,0.3;0.6,0.6;0.9,0.9 则0.3,0.3是近景跟随速度比例，0.6.0.6是中景跟随速度比例，0.9,0.9是远景跟随速度比例
    #当背景类型为地下时，资源列表为随机的图片，速度比例只有一个，代表整体的移动速度比例
    
    #未导表的不检查
    pass_meg = 'pass'
    type_error = key+' 的Type填写错误'
    type_null = key+' 的Type未填'
    backgroundPath_error = key+' 的背景资源路径不存在'
    backgroundPath_null = key+' 的背景资源路径错误'
    deviation_error = key+' 的人物图片偏移填写错误'
    horizonY_error = key+' 的Horizony填写错误'
    horizonY_null = key+' 的Horizony未填'
    nightBackgroundPath_error = key+' 的黑夜背景资源路径不存在'
    nightBackgroundPath_null = key+' 的黑夜背景资源路径错误'
    nightBackgroundSpeed_error = key+' 的黑夜背景移动速度比例填写错误'
    nightBackgroundSpeed_null = key+' 的黑夜背景移动速度比例未填写全'
    backgroundSpeed_error = key+' 的背景移动速度比例填写错误'
    backgroundSpeed_null = key+' 的背景移动速度比例未填写全'
    
    if Unnamed != '是':
        
        return pass_meg
    error_list = []
    #背景类型必须为1或2
    if type is not None:
        if type != 1 and type != 2:
            error_list.append(type_error)
    else:
        error_list.append(type_null)
    #背景资源列表字段中的资源必须存在，资源之间用“；”或“：”间隔
    #路径正则表达式
    pathPattern = re.compile(r'^(?:[a-zA-Z]:\\(?:[^<>:"/\\|?*\r\n]+\\?)*|/[^<>:"|?*\r\n]+(/[^<>:"|?*\r\n]*)*\/?)$')
    if backgroundList is  None:#wrong
        backgroundPathList = backgroundList.split(';')
        for backgroundPath in backgroundPathList:
            if not pathPattern.match(backgroundPath):
                if ':' in backgroundPath:
                    #背景资源路径中有“：”则为随机资源
                    randomPathList = backgroundPath.split(':')
                    for randomPath in randomPathList:
                        if not pathPattern.match(randomPath):
                            error_list.append(backgroundPath_error+randomPath)
                else:
                    error_list.append(backgroundPath_error+backgroundPath)
    else:
        error_list.append(backgroundPath_null)
        
    #如果人物图片偏移不为空，则格式为“数字，数字”，即字符串需要可转为List(Float(), ",")
    if deviation is not None:
        deviationList = deviation.split(',')
        if len(deviationList) != 2:
            error_list.append(deviation_error)
        else:
            for deviation in deviationList:
                try:
                    float(deviation)
                except ValueError:
                    #error_list.append( deviation_error)
                    error_list.append(pass_meg)
    #如果背景类型为地上，则地平线值不为空，且为一个整数,可能为负数
    if type == 1:
        #检查地平线    
        if horizonY is not None:
            try:
                int(horizonY)
            except ValueError:
                error_list.append( horizonY_error)
        else:
            error_list.append( horizonY_null)
        #检查黑夜背景资源列表与跟随移动速度比例
        if nightBackgroundList is not None:
            nightBackgroundPathList = nightBackgroundList.split(';')
            for nightBackgroundPath in nightBackgroundPathList:
                if not pathPattern.match(nightBackgroundPath):
                    if ':' in nightBackgroundPath:
                        #背景资源路径中有“：”则为随机资源
                        randomPathList = nightBackgroundPath.split(':')
                        for randomPath in randomPathList:
                            if not pathPattern.match(randomPath):
                                error_list.append(nightBackgroundPath_error+randomPath)
                    else:
                        error_list.append( nightBackgroundPath_error+nightBackgroundPath)
        else:
            error_list.append( nightBackgroundPath_null)
            
        #黑夜背景跟随移动速度比例
        nightBackgroundSpeedList = nightBackgroundSpeedList.split(';')
        if len(nightBackgroundSpeedList) == len(nightBackgroundPathList) :#wrong
            
            error_list.append( nightBackgroundSpeed_null)    
        else:
            for nightBackgroundSpeed in nightBackgroundSpeedList:
                speedList = nightBackgroundSpeed.split(',')
                if len(speedList) != 2:
                    error_list.append(nightBackgroundSpeed_error)
                else:
                    for speed in speedList:
                        #speed符合float型
                        try:
                            float(speed)
                        except ValueError:
                            error_list.append(nightBackgroundSpeed_error)
        #跟随移动速度比例的数字个数必须为资源个数的两倍，且数字间用“，”间隔，每两个数字间用“；”间隔
        if backgroundSpeedList is not None:
            backgroundSpeedList = backgroundSpeedList.split(';')
            if len(backgroundSpeedList) != len(backgroundPathList) :
                error_list.append(backgroundSpeed_error) 
            else:
                for backgroundSpeed in backgroundSpeedList:
                    speedList = backgroundSpeed.split(',')
                    if len(speedList) != 2:
                        error_list.append( backgroundSpeed_error)
                    else:
                        for speed in speedList:
                            #speed符合float型
                            try:
                                float(speed)
                            except ValueError:
                                error_list.append( backgroundSpeed_error)
        else:
            error_list.append( backgroundSpeed_null)
                          
        if len(error_list) == 0:
            
            return pass_meg
        else:
            return error_list
if __name__ == '__main__':
    key = '1'
    type = 1
    backgroundList = '1.png;2.png;3.png'
    backgroundSpeedList = '0.3,0.3;0.6,0.6;0.9,0.9'
    deviation = '0.5,0.5'
    horizonY = 34
    nightBackgroundList = '1.png;2.png;3.png'
    nightBackgroundSpeedList = '0.3,0.3;0.6,0.6;0.9,0.9'
    Unnamed = '是'
    print(testHome2DBackground(key,type,backgroundList,backgroundSpeedList,deviation,horizonY,nightBackgroundList,nightBackgroundSpeedList,Unnamed))
    key = '2'
    type = 1
    backgroundList = '1.png;2.png;3.png'
    backgroundSpeedList = '0.3,0.3;0.6,0.6;0.9,0.9'
    deviation = '0.5,0.5'
    horizonY = 1
    nightBackgroundList = '1.png;2.png;3.png'
    nightBackgroundSpeedList = '0.3,0.3;0.6,0.6;0.9,0.9'
    Unnamed = '否'
    print(testHome2DBackground(key,type,backgroundList,backgroundSpeedList,deviation,horizonY,nightBackgroundList,nightBackgroundSpeedList,Unnamed))
    key = '3'
    type = 1
    backgroundList = '1.png;2.png;3.png'
    backgroundSpeedList = '0.3,0.3;0.6,0.6;0.9,0.9'
    deviation = '0.5,0.5'
    horizonY = 0
    nightBackgroundList = '1.png;2.png;3.png'
    nightBackgroundSpeedList = '0.3,0.3;0.6,0.6;0.9,0.9'
    Unnamed = '是'
    print(testHome2DBackground(key,type,backgroundList,backgroundSpeedList,deviation,horizonY,nightBackgroundList,nightBackgroundSpeedList,Unnamed))
             

'''
import Base
import re

class testHome2DBackground(Base.sheetData):
    def __init__(self):
        self.kimName = "wangzichen06"
        self.home2DBg = Base.sheetData("家园背景表", "背景表", "ID")
        
        for key in self.home2DBg.keys():
            #未导表的不检查
            if self.home2DBg.value(key, 'Unnamed: 0') != '是':
                continue
            #背景类型必须为1或2
            type = self.home2DBg.value(key, 'Type')
            if type is not None:
                if int(type) not in [1, 2]:
                    self.home2DBg.error('%d 的Type填写错误' % int(key))
            else:
                self.home2DBg.error('%d 的Type未填' % int(key))
            #背景资源列表字段中的资源必须存在，资源之间用“；”或“：”间隔
            
            #支持背景多层级随机，则背景资源列表格式变为层级之间“;”间隔，随机资源之间":"间隔，背景跟随移动速度比例对应每一个背景资源
            #多个背景资源路径写的顺序代表背景层级，写越前面代表离玩家越近，比如有三个背景资源：资源路径1；资源路径2；资源路径3，则1是近景，2是中景，3是远景
            #多个背景跟随移动速度比例写的顺序代表背景层级，比如有三个数值：0.3,0.3;0.6,0.6;0.9,0.9 则0.3,0.3是近景跟随速度比例，0.6.0.6是中景跟随速度比例，0.9,0.9是远景跟随速度比例
            #当背景类型为地下时，资源列表为随机的图片，速度比例只有一个，代表整体的移动速度比例
            
            backgroundList = self.home2DBg.value(key, 'BackgroundList')
            backgroundPathList = Base.toList(backgroundList, ';')
            for backgroundPath in backgroundPathList:
                if not Base.checkPath(backgroundPath):
                    if ':' in backgroundPath:
                        #背景资源路径中有“：”则为随机资源
                        randomPathList = Base.toList(backgroundPath, ':')
                        for randomPath in randomPathList:
                            if not Base.checkPath(randomPath):
                                self.home2DBg.error('%d 的背景资源%s路径不存在' % (int(key), randomPath))
                    else:
                        self.home2DBg.error('%d 的背景资源%s路径错误' % (int(key), backgroundPath))        
            #如果人物图片偏移不为空，则格式为“数字，数字”，即字符串需要可转为List(Float(), ",")
            deviation = self.home2DBg.value(key, 'Deviation')
            if deviation is not None:
                deviationList = Base.toList(deviation, ',')
                if len(deviationList) != 2:
                    self.home2DBg.error('%d 的人物图片偏移填写错误' % int(key))
                else:
                    for deviation in deviationList:
                        if not self.checkFloat(deviation):
                            self.home2DBg.error('%d 的人物图片偏移填写错误' % int(key))
                            
            #如果背景类型为地上，则地平线值不为空，且为一个整数,可能为负数
            horizonY = self.home2DBg.value(key, 'HorizonY')
            #背景类型为1：地上 同时检查黑夜背景，检查规则与白天背景一致
            if type == 1:
                #检查地平线    
                if horizonY is not None:
                    if not isinstance(horizonY, int):
                        self.home2DBg.error('%d 的Horizony填写错误' % int(key))
                else:
                    self.home2DBg.error('%d 的Horizony未填' % int(key))
                #检查黑夜背景资源列表与跟随移动速度比例
                nightBackgroundList = self.home2DBg.value(key, 'NightBackgroundList')
                nightBackgroundPathList = Base.toList(nightBackgroundList, ';')
                for nightBackgroundPath in nightBackgroundPathList:
                    if not Base.checkPath(nightBackgroundPath):
                        if ':' in nightBackgroundPath:
                            #背景资源路径中有“：”则为随机资源
                            randomPathList = Base.toList(nightBackgroundPath, ':')
                            for randomPath in randomPathList:
                                if not Base.checkPath(randomPath):
                                    self.home2DBg.error('%d 的黑夜背景资源%s路径不存在' % (int(key), randomPath))
                        else:
                            self.home2DBg.error('%d 的黑夜背景资源%s路径错误' % (int(key), nightBackgroundPath))
                #黑夜背景跟随移动速度比例
                nightBackgroundSpeeds = self.home2DBg.value(key, 'NightBackgroundSpeedList')
                nightBackgroundSpeedList = Base.toList(nightBackgroundSpeeds, ';')
                if len(nightBackgroundSpeedList) != len(nightBackgroundPathList) :
                    self.home2DBg.error('%d 的黑夜背景移动速度比例未填写全' % int(key))    
                else:
                    for nightBackgroundSpeed in nightBackgroundSpeedList:
                        speedList = Base.toList(nightBackgroundSpeed, ',')
                        if len(speedList) != 2:
                            self.home2DBg.error('%d 的黑夜背景移动速度比例未填写全' % int(key))
                        else:
                            for speed in speedList:
                                #speed符合float型
                                if not self.checkFloat(speed):
                                    self.home2DBg.error('%d 的黑夜背景移动速度比例填写错误' % int(key))
                    
            #跟随移动速度比例的数字个数必须为资源个数的两倍，且数字间用“，”间隔，每两个数字间用“；”间隔
            #TODO:随机资源的速度比例检查情况先不做
            backgroundSpeeds = self.home2DBg.value(key, 'BackgroundSpeedList')
            backgroundSpeedList = Base.toList(backgroundSpeeds, ';')
            if len(backgroundSpeedList) != len(backgroundPathList) :
                print(len(backgroundSpeedList))
                print(len(backgroundList))
                self.home2DBg.error('%d 的背景移动速度比例未填写全' % int(key))    
            else:
                for backgroundSpeed in backgroundSpeedList:
                    speedList = Base.toList(backgroundSpeed, ',')
                    if len(speedList) != 2:
                        self.home2DBg.error('%d 的背景移动速度比例填写错误' % int(key))
                    else:
                        for speed in speedList:
                            #speed符合float型
                            if not self.checkFloat(speed):
                                self.home2DBg.error('%d 的背景移动速度比例填写错误' % int(key))
            
        #判断字符串是不是float型，如"0.35"和"0.9"都是float型
    def checkFloat(self,s):
        try:
            float(s)
            return True
        except ValueError:
            return False          
'''