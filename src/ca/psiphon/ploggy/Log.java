/*
 * Copyright (c) 2013, Psiphon Inc.
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package ca.psiphon.ploggy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Log {

    public static class Entry {
        public final String mTag;
        public final String mMessage;
        public final Date mTimestamp;

        public Entry(String tag, String message) {
            mTag = tag;
            mMessage = message;
            mTimestamp = new Date();
        }
    }
    
    private static List<Entry> mEntries = Collections.synchronizedList(new ArrayList<Entry>());

    public static List<Entry> getEntries() {
    	return mEntries;
    }
    
    public static void addEntry(String tag, String message) {
    	mEntries.add(new Entry(tag, message));
    	// TODO: truncate
    	Events.post(new Events.AddedLogEntry());
    }
}
